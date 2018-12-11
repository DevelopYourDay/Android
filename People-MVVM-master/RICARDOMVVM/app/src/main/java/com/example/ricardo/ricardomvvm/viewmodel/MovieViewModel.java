package com.example.ricardo.ricardomvvm.viewmodel;

import android.content.Context;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.ObservableInt;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ricardo.ricardomvvm.data.remote.MovieRepository;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetPopularMovies;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.view.notifications.Toasts;
import com.example.ricardo.ricardomvvm.databinding.MovieMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ricardo on 10/12/2018
 */
public class MovieViewModel extends Observable {

    private static final int DEFAULT_VALUE_FROM_PAGE_REQUEST = 1;
    private static final boolean DEFAULT_VALUE_FROM_FETECHING_MOVIES_REQUEST = false;

    public ObservableInt movieProgress;
    public ObservableInt movieRecycler;
    public ObservableInt viewNoInternetConnection;

    private List<Movie> movieList;
    private Context context;
    private Cursor mCursor;


    private boolean isFetchingMovies;
    private int currentPage;


    private static  CompositeDisposable compositeDisposable = new CompositeDisposable();

   // private ActivityMainBinding movieActivityBinding;


    public MovieViewModel(Context context) {
        this.movieProgress = new ObservableInt(View.VISIBLE);
        this.movieRecycler = new ObservableInt(View.GONE);
        this.viewNoInternetConnection = new ObservableInt(View.GONE);
        this.movieList = new ArrayList<>();
        this.context = context;
        initializeAttributes();
        initializeViews();
        fetchPopularMoviesList();

    }

    public void initializeAttributes() {
        isFetchingMovies = false;
        currentPage = DEFAULT_VALUE_FROM_PAGE_REQUEST;
    }

    public void initializeViews() {
        movieRecycler.set(View.GONE);
        movieProgress.set(View.VISIBLE);
    }

    private void fetchPopularMoviesList() {
        isFetchingMovies = true;
        MovieRepository.getPopularMovies(context, compositeDisposable,currentPage, new GetPopularMovies() {
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

    @BindingAdapter({"android:onScroll"})
    public void onScroll(View view) {
      /** // if (!getPredefinedTypeSearchMovie().equals(MOVIES_FAVORITES)) {

            if (movieActivityBinding.rvListMovies.getLayoutManager() instanceof GridLayoutManager) {

                GridLayoutManager layoutManager = (GridLayoutManager) movieActivityBinding.rvListMovies.getLayoutManager();
                int totalItemCount = layoutManager.getItemCount();
                int visibleItemCount = layoutManager.getChildCount();
                int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    if (!isFetchingMovies) {
                        currentPage++;
                       //handler where call fetch movies
                        fetchPopularMoviesList();
                    }
                }
            }
        //}**/
    }

}
