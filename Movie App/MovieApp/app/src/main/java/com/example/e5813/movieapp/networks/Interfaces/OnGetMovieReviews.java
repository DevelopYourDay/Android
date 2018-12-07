package com.example.e5813.movieapp.networks.Interfaces;

import com.example.e5813.movieapp.models.MovieReviews;
import com.example.e5813.movieapp.models.Responses.MovieReviewsResponse;

import java.util.List;

public interface OnGetMovieReviews {

    void onSuccess(List<MovieReviews> movies);
    void onError();
}
