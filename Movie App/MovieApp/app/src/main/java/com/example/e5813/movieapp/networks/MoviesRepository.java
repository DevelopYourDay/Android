package com.example.e5813.movieapp.networks;

import android.support.annotation.NonNull;

import com.example.e5813.movieapp.models.MovieDetails;
import com.example.e5813.movieapp.models.MovieReviews;
import com.example.e5813.movieapp.models.Responses.MovieReviewsResponse;
import com.example.e5813.movieapp.models.Responses.MovieVideosResponse;
import com.example.e5813.movieapp.models.Responses.MoviesResponse;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMovieDetails;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMovieReviews;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMovieTopRated;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMoviesCallback;
import com.example.e5813.movieapp.networks.Interfaces.OnGetVideosFromMovie;
import com.example.e5813.movieapp.networks.Interfaces.TmdbApiService;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesRepository {

    final static String LANGUAGE = "en-US";

    final static String API_KEY = "b7ecf52683a89db9aedbdc0ff9f31f25";

    public  static void getMovies(TmdbApiService api,int page, final OnGetMoviesCallback callback) {
        api.listPopularMovies(API_KEY, LANGUAGE,page).enqueue(new Callback<MoviesResponse>() {
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

    public static void getMoviesDetails(TmdbApiService api, int movie_id, final OnGetMovieDetails callback) {
        api.movieDetails(movie_id,API_KEY, LANGUAGE).enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(@NonNull Call<MovieDetails> call, @NonNull Response<MovieDetails> response) {
                if (response.isSuccessful()) {
                    MovieDetails moviesResponse = response.body();
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
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public static void getMoviesTopRated(TmdbApiService api,int page ,final OnGetMovieTopRated callback) {
        api.listTopRated(API_KEY, LANGUAGE,page).enqueue(new Callback<MoviesResponse>() {
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

    public static void getMoviesReviews(TmdbApiService api,int idMovie,final OnGetMovieReviews callback) {
        api.listMoviesReviews(idMovie,API_KEY, LANGUAGE).enqueue(new Callback<MovieReviewsResponse>() {
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

    public static void getVideosFromMovies(TmdbApiService api,int idMovie,final OnGetVideosFromMovie callback) {
        api.listVideosFromMovie(idMovie,API_KEY, LANGUAGE).enqueue(new Callback<MovieVideosResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieVideosResponse> call, @NonNull Response<MovieVideosResponse> response) {
                if (response.isSuccessful()) {
                    MovieVideosResponse movieVideosResponse = response.body();
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
            public void onFailure(Call<MovieVideosResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }
}



