package com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices;


import com.example.ricardo.ricardomvvm.model.MovieTrailler;

import java.util.List;

public interface GetTraillersFromMovie {

   void onSuccess(List<MovieTrailler> movies);
    void onError();
}
