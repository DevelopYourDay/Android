package com.example.e5813.movieapp.networks;

import com.example.e5813.movieapp.models.Movie;

import java.util.List;

public interface OnGetMoviesCallback {
    void onSuccess(List<Movie> movies);
    void onError();
}

