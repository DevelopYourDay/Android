package com.example.ricardo.ricardomvvm.data.remote;

import android.content.Context;

import com.example.ricardo.ricardomvvm.Utils.MovieApplication;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.*;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.example.ricardo.ricardomvvm.model.MovieReview;
import com.example.ricardo.ricardomvvm.model.MovieTrailler;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class MovieRepository {


    final static String LANGUAGE = "en-US";
    final static String API_KEY = "b7ecf52683a89db9aedbdc0ff9f31f25";



    public static void getPopularMovies(CompositeDisposable compositeDisposable,int page, final GetPopularMovies callback) {

        Disposable disposable = MoviesFactory.create().GetPopularMovies(API_KEY,LANGUAGE,page)
                .subscribeOn(MovieApplication.subscribeScheduler())
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

    public static void getTopRatedMovies(CompositeDisposable compositeDisposable,int page, final GetTopRatedMovies callback) {

        Disposable disposable = MoviesFactory.create().GetTopRatedMovies(API_KEY,LANGUAGE,page)
                .subscribeOn(MovieApplication.subscribeScheduler())
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


    public static void getDetailsFromMovie(int movieId, final GetDetailsFromMovie callback) {

        Disposable disposable = MoviesFactory.create().GetDetailsFromMovie(movieId,API_KEY,LANGUAGE)
                .subscribeOn(MovieApplication.subscribeScheduler())
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
    }


    public static void getReviewsFromDetailsMovie(int movieId, final GetReviewsFromMovie callback) {

        Disposable disposable = MoviesFactory.create().GetReviewsFromMovie(movieId,API_KEY,LANGUAGE)
                .subscribeOn(MovieApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieReview.MovieReviewsResponse>() {
                    @Override public void accept( MovieReview.MovieReviewsResponse movieReviews) {
                        callback.onSuccess(movieReviews.getListMoviesReviews());
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                        callback.onError();
                    }
                });
    }


    public static void getTrailersFromDetailsMovie(int movieId, final GetTraillersFromMovie callback) {

        Disposable disposable = MoviesFactory.create().GetTrailersFromMovie(movieId,API_KEY,LANGUAGE)
                .subscribeOn(MovieApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieTrailler.MovieTrailersResponse>() {
                    @Override public void accept( MovieTrailler.MovieTrailersResponse movieTrailers) {
                        callback.onSuccess(movieTrailers.getListvideosFromMovie());
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                        callback.onError();
                    }
                });
    }
}
