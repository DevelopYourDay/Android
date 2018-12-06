package com.example.e5813.movieapp.networks.Interfaces;

import com.example.e5813.movieapp.models.Movie;

import java.util.List;

public interface OnGetMovieTopRated {
        void onSuccess(int page, List<Movie> movies);
        void onError();
}
