package com.example.ricardo.ricardomvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.view.View;

import com.example.ricardo.ricardomvvm.MovieApplication;
import com.example.ricardo.ricardomvvm.data.MovieService;
import com.example.ricardo.ricardomvvm.data.MoviesFactory;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MoviesResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Ricardo on 10/12/2018
 */
public class MovieViewModel  extends Observable {
    public ObservableInt peopleProgress;
    public ObservableInt peopleRecycler;
    public ObservableInt viewNoInternetConnection;

    private List<Movie> movieList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MovieViewModel(Context context) {
        this.peopleProgress = new ObservableInt(View.VISIBLE);
        this.peopleRecycler =  new ObservableInt(View.GONE);
        this.viewNoInternetConnection = new ObservableInt(View.GONE);
        this.movieList = new ArrayList<>();
        this.context = context;
    }

    public void onclickFabLoad (View view){
        initializeViews();
        fetchMovieList();
    }

    public void initializeViews() {
        peopleRecycler.set(View.GONE);
        peopleProgress.set(View.VISIBLE);
    }

    private void fetchMovieList() {

        MovieApplication movieApplication = MovieApplication.create(context);
        MovieService movieService = movieApplication.getMovieService();

        Disposable disposable = movieService.GetPopularMovies(MoviesFactory.API_KEY,MoviesFactory.LANGUAGE,1)
                .subscribeOn(movieApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResponse>() {
                    @Override public void accept(MoviesResponse moviesResponse) {
                        changeMovieDataSet(moviesResponse.getMovies());
                        peopleProgress.set(View.GONE);
                        peopleRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                        peopleProgress.set(View.GONE);
                        peopleRecycler.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void changeMovieDataSet(List<Movie> Movies) {
        movieList.addAll(Movies);
        setChanged();
        notifyObservers();
    }

    public List<Movie> getPeopleList() {
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
}
