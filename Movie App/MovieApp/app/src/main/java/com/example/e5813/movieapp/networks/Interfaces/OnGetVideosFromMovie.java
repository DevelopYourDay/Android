package com.example.e5813.movieapp.networks.Interfaces;

import com.example.e5813.movieapp.models.Responses.MovieVideosResponse;

import java.util.List;

public interface OnGetVideosFromMovie {

    void onSuccess(List<MovieVideosResponse> movies);
    void onError();
}
