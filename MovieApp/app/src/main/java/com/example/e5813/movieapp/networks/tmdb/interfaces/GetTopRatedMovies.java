package com.example.e5813.movieapp.networks.tmdb.interfaces;

import com.example.e5813.movieapp.models.movies.Movie;

import java.util.List;

public interface GetTopRatedMovies {
        void onSuccess(int page, List<Movie> movies);
        void onError();
}
