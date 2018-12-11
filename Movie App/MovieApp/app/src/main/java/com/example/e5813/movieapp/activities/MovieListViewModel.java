package com.example.e5813.movieapp.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.e5813.movieapp.models.movies.Movie;

/**
 * Created by Ricardo on 10/12/2018
 */
public class MovieListViewModel extends ViewModel {

    private LiveData<Movie> movie;


    public LiveData<Movie> getMovie() {
        return movie;
    }
}
