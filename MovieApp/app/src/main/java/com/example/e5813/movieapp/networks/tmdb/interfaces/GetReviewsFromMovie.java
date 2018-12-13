package com.example.e5813.movieapp.networks.tmdb.interfaces;

import com.example.e5813.movieapp.models.movies.MovieReview;

import java.util.List;

public interface GetReviewsFromMovie {

    void onSuccess(List<MovieReview> movies);
    void onError();
}
