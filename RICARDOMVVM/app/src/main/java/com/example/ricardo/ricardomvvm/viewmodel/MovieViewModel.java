package com.example.ricardo.ricardomvvm.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ricardo.ricardomvvm.data.remote.MovieRepository;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetPopularMovies;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetTopRatedMovies;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.view.MovieActivity;
import com.example.ricardo.ricardomvvm.view.notifications.Toasts;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;

import static com.example.ricardo.ricardomvvm.view.MovieActivity.PREFS_MOVIE_TYPE_KEY;
import static com.example.ricardo.ricardomvvm.view.MovieActivity.PREFS_NAME_FILE;
import static com.example.ricardo.ricardomvvm.view.MovieActivity.PREFS_SORT_MOVIE_DEFAULT;

/**
 * Created by Ricardo on 10/12/2018
 */

public class MovieViewModel extends Observable {

    private static final int DEFAULT_VALUE_FROM_PAGE_REQUEST = 1;
    private static final boolean DEFAULT_VALUE_FROM_FETECHING_MOVIES_REQUEST = false;

    public ObservableInt movieProgress;
    public ObservableInt movieRecycler;
    public ObservableInt viewNoInternetConnection;
    public ObservableBoolean isLoading;
    private List<Movie> movieList;
    private Context context;
    private Cursor mCursor;


    private boolean isFetchingMovies;
    private int currentPage;


    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private ActivityMovieBinding movieActivityBinding;


    public MovieViewModel(Context context) {
        this.movieProgress = new ObservableInt(View.VISIBLE);
        this.movieRecycler = new ObservableInt(View.GONE);
        this.isLoading = new ObservableBoolean();
        this.viewNoInternetConnection = new ObservableInt(View.GONE);
        this.movieList = new ArrayList<>();
        this.context = context;
        initializeAttributes();
        initializeViews();
        fetchData();

    }


    public void fetchData() {
        switch (getPredefinedTypeSearchMovie()) {
            case MovieActivity.MOVIES_POPULAR:
                fetchPopularMoviesList();
                break;
            case MovieActivity.MOVIES_TOP_RATED:
                fetchTopRatedMoviesList();
                break;
            default:
                break;
        }
    }


    public void onChangedTypeSearchMovie() {
        initializeAttributes();
        fetchData();
    }

    public void initializeAttributes() {
        isFetchingMovies = false;
        currentPage = DEFAULT_VALUE_FROM_PAGE_REQUEST;
        if (movieList.size() > 0) {
            movieList.clear();
        }
    }

    public void initializeViews() {
        movieRecycler.set(View.GONE);
        movieProgress.set(View.VISIBLE);
    }

    private void fetchPopularMoviesList() {
        isFetchingMovies = true;
        MovieRepository.getPopularMovies(compositeDisposable, currentPage, new GetPopularMovies() {
            @Override
            public void onSuccess(int page, List<Movie> movies) {
                changeMovieDataSet(movies);
                currentPage = page;
                isFetchingMovies = false;
                movieProgress.set(View.GONE);
                movieRecycler.set(View.VISIBLE);
            }

            @Override
            public void onError() {
                Toast toast = Toasts.createToastNoInternetConnection(context);
                toast.show();
            }
        });
    }

    private void fetchTopRatedMoviesList() {
        isFetchingMovies = true;
        MovieRepository.getTopRatedMovies(compositeDisposable, currentPage, new GetTopRatedMovies() {
            @Override
            public void onSuccess(int page, List<Movie> movies) {
                changeMovieDataSet(movies);
                currentPage = page;
                isFetchingMovies = false;
                movieProgress.set(View.GONE);
                movieRecycler.set(View.VISIBLE);
            }

            @Override
            public void onError() {
                Toast toast = Toasts.createToastNoInternetConnection(context);
                toast.show();
            }
        });
    }

    private void changeMovieDataSet(List<Movie> Movies) {
        movieList.addAll(Movies);
        setChanged();
        notifyObservers();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }

    /**
     * call refresh SwipeRefreshLayout
     */
    public void onRefresh() {
        isLoading.set(true);
        fetchData();
        isLoading.set(false);
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            int totalItemCount = layoutManager.getItemCount();
            int visibleItemCount = layoutManager.getChildCount();
            int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

            if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                if (!isFetchingMovies) {
                    currentPage++;
                    fetchData();
                }
            }
        }
    }

    private String getPredefinedTypeSearchMovie() {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME_FILE, 0);
        String moviePref = settings.getString(PREFS_MOVIE_TYPE_KEY, PREFS_SORT_MOVIE_DEFAULT);
        return moviePref;
    }


}
