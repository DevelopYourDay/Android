package com.example.e5813.movieapp.networks.tmdb.interfaces;


import com.example.e5813.movieapp.models.movies.MovieDetail;

public interface GetDetailsFromMovie {

        void onSuccess(MovieDetail movieDetails);
        void onError();
}
