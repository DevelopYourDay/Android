package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
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

public class MovieViewModel extends ViewModel {

    private static final int DEFAULT_VALUE_FROM_PAGE_REQUEST = 1;

    private static String PredefinedTypeSearchMovie;

    public ObservableInt movieProgress =new ObservableInt(View.VISIBLE);
    public ObservableInt movieRecycler  = new ObservableInt(View.GONE);
    public ObservableBoolean isLoading = new ObservableBoolean();
    public MutableLiveData<Boolean> NoInternetConnection = new MutableLiveData<>();
    private MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();



    private boolean isFetchingMovies;
    private int currentPage;


    private CompositeDisposable compositeDisposable = new CompositeDisposable();



    public void fetchData() {
        switch (PredefinedTypeSearchMovie) {
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
        initializeViews();
        fetchData();
    }

    public void initializeAttributes() {
        isFetchingMovies = false;
        currentPage = DEFAULT_VALUE_FROM_PAGE_REQUEST;
        movieList.setValue(new ArrayList<>());
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
                movieList.setValue(movies);
                currentPage = page;
                isFetchingMovies = false;
                movieProgress.set(View.GONE);
                movieRecycler.set(View.VISIBLE);
            }
            @Override
            public void onError() {
               NoInternetConnection.setValue(true);
            }
        });
    }

    private void fetchTopRatedMoviesList() {
        isFetchingMovies = true;
        MovieRepository.getTopRatedMovies(compositeDisposable, currentPage, new GetTopRatedMovies() {
            @Override
            public void onSuccess(int page, List<Movie> movies) {
                movieList.setValue(movies);
                currentPage = page;
                isFetchingMovies = false;
                movieProgress.set(View.GONE);
                movieRecycler.set(View.VISIBLE);
            }

            @Override
            public void onError() {
                NoInternetConnection.setValue(true);
            }
        });
    }


    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
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

    public  LiveData<Boolean> getNoInternetConnection(){
        return NoInternetConnection;
    }

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }

    public void setPredefinedTypeSearchMovie(String newPredifineMovie){
        this.PredefinedTypeSearchMovie = newPredifineMovie;
    }

}
