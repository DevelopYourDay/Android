package com.example.ricardo.ricardomvvm.data.remote;

import android.content.Context;

import com.example.ricardo.ricardomvvm.MovieApplication;
import com.example.ricardo.ricardomvvm.model.MoviesResponse;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.*;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class MovieRepository {


    final static String LANGUAGE = "en-US";
    final static String API_KEY = "b7ecf52683a89db9aedbdc0ff9f31f25";



    public static void getPopularMovies(Context context, CompositeDisposable compositeDisposable,int page, final GetPopularMovies callback) {

        MovieApplication movieApplication = MovieApplication.create(context);
        MovieService movieService = movieApplication.getMovieService();

        Disposable disposable = movieService.GetPopularMovies(API_KEY,LANGUAGE,page)
                .subscribeOn(movieApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResponse>() {
                    @Override public void accept(MoviesResponse moviesResponse) {
                    callback.onSuccess(moviesResponse.page, moviesResponse.getMovies());
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                        callback.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }
}
