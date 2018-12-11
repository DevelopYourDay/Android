package com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices;

import com.example.ricardo.ricardomvvm.model.Movie;

import java.util.List;

public interface GetPopularMovies {
        void onSuccess(int page,List<Movie> movies);
        void onError();
}
