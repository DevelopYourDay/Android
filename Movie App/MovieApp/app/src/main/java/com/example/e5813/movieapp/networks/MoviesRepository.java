package com.example.e5813.movieapp.networks;

import android.support.annotation.NonNull;

import com.example.e5813.movieapp.models.MovieDetails;
import com.example.e5813.movieapp.models.MoviesResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesRepository {

    final static String LANGUAGE = "en-US";

    final static String API_KEY = "<api_key>";

    public static void getMovies(TmdbApiService api, final OnGetMoviesCallback callback) {
        api.listPopularMovies(API_KEY, LANGUAGE).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getMovies());
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

    public static void getMoviesTopRated(TmdbApiService api, final OnGetMoviesCallback callback) {
        api.listPopularMovies(API_KEY, LANGUAGE).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getMovies());
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
}



