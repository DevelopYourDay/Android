package com.example.e5813.movieapp.networks.tmdb.interfaces;

import com.example.e5813.movieapp.models.movies.MovieTrailler;

import java.util.List;

public interface GetTraillersFromMovie {

    void onSuccess(List<MovieTrailler> movies);
    void onError();
}
