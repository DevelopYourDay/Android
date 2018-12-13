package com.example.ricardo.ricardomvvm.data.remote;

import android.content.Context;

import com.example.ricardo.ricardomvvm.Utils.MovieApplication;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.*;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieDetail;

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
                .subscribe(new Consumer<Movie.MovieResponse>() {
                    @Override public void accept(Movie.MovieResponse moviesResponse) {
                    callback.onSuccess(moviesResponse.page, moviesResponse.getMovies());
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                        callback.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }

    public static void getTopRatedMovies(Context context, CompositeDisposable compositeDisposable,int page, final GetTopRatedMovies callback) {

        MovieApplication movieApplication = MovieApplication.create(context);
        MovieService movieService = movieApplication.getMovieService();
        Disposable disposable = movieService.GetTopRatedMovies(API_KEY,LANGUAGE,page)
                .subscribeOn(movieApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Movie.MovieResponse>() {
                    @Override public void accept(Movie.MovieResponse moviesResponse) {
                        callback.onSuccess(moviesResponse.page, moviesResponse.getMovies());
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                        callback.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }


    public static void getDetailsFromMovie(Context context, CompositeDisposable compositeDisposable, int movieId, final GetDetailsFromMovie callback) {

        MovieApplication movieApplication = MovieApplication.create(context);
        MovieService movieService = movieApplication.getMovieService();

        Disposable disposable = movieService.GetDetailsFromMovie(movieId,API_KEY,LANGUAGE)
                .subscribeOn(movieApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieDetail>() {
                    @Override public void accept( MovieDetail movieDetail) {
                        callback.onSuccess(movieDetail);
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                        callback.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }
}
