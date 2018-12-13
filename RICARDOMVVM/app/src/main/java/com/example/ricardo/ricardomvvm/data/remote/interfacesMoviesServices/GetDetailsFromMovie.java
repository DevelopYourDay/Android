package com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices;


import com.example.ricardo.ricardomvvm.model.MovieDetail;

public interface GetDetailsFromMovie {

        void onSuccess(MovieDetail movieDetails);
        void onError();
}
