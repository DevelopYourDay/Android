package com.example.e5813.movieapp.networks.tmdb.movies;

import android.support.annotation.NonNull;

import com.example.e5813.movieapp.activities.MovieDetails;
import com.example.e5813.movieapp.models.movies.MovieDetail;
import com.example.e5813.movieapp.models.movies.responses.MovieReviewsResponse;
import com.example.e5813.movieapp.models.movies.responses.MovieTrailersResponse;
import com.example.e5813.movieapp.models.movies.responses.MoviesResponse;
import com.example.e5813.movieapp.networks.tmdb.TmdbClientInstance;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetDetailsFromMovie;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetReviewsFromMovie;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetTopRatedMovies;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetPopularMovies;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetTraillersFromMovie;
import com.example.e5813.movieapp.networks.tmdb.interfaces.TmdbApiService;


import java.io.IOException;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieRepository {

    final static String LANGUAGE = "en-US";

    final static String API_KEY = "b7ecf52683a89db9aedbdc0ff9f31f25";

    public static void getPopularMovies(TmdbApiService api,int page, final GetPopularMovies callback) {
        api.GetPopularMovies(API_KEY, LANGUAGE,page).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getPage(),moviesResponse.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public static void getTopRatedMovies(TmdbApiService api,int page ,final GetTopRatedMovies callback) {
        api.GetTopRatedMovies(API_KEY, LANGUAGE,page).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getPage(),moviesResponse.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public static void getDetailsFromMovie(TmdbApiService api, int movie_id, final GetDetailsFromMovie callback) {
        api.GetDetailsFromMovie(movie_id,API_KEY, LANGUAGE).enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(@NonNull Call<MovieDetail> call, @NonNull Response<MovieDetail> response) {
                if (response.isSuccessful()) {
                    MovieDetail moviesResponse = response.body();
                    if (moviesResponse != null) {
                        callback.onSuccess(moviesResponse);
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public static void getReviewsFromMovie(TmdbApiService api,int idMovie,final GetReviewsFromMovie callback) {
        api.GetReviewsFromMovie(idMovie,API_KEY, LANGUAGE).enqueue(new Callback<MovieReviewsResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieReviewsResponse> call, @NonNull Response<MovieReviewsResponse> response) {
                if (response.isSuccessful()) {
                    MovieReviewsResponse movieReviewsResponse = response.body();
                    if (movieReviewsResponse != null && movieReviewsResponse.getListMoviesReviews()!= null) {
                        callback.onSuccess(movieReviewsResponse.getListMoviesReviews());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<MovieReviewsResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public static void getTrailersFromMovies(TmdbApiService api,int idMovie,final GetTraillersFromMovie callback) {
        api.GetTrailersFromMovie(idMovie,API_KEY, LANGUAGE).enqueue(new Callback<MovieTrailersResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieTrailersResponse> call, @NonNull Response<MovieTrailersResponse> response) {
                if (response.isSuccessful()) {
                    MovieTrailersResponse movieVideosResponse = response.body();
                    if (movieVideosResponse != null && movieVideosResponse.getListvideosFromMovie()!= null) {
                        callback.onSuccess(movieVideosResponse.getListvideosFromMovie());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<MovieTrailersResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }







}




