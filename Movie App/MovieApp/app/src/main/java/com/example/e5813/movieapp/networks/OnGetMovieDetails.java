package com.example.e5813.movieapp.networks;


import com.example.e5813.movieapp.models.MovieDetails;

public interface OnGetMovieDetails {

        void onSuccess(MovieDetails movieDetails);
        void onError();
}
