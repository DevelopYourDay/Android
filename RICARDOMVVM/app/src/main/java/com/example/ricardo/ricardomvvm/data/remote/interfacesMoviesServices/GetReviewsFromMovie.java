package com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices;

import com.example.ricardo.ricardomvvm.model.MovieReview;

import java.util.List;

public interface GetReviewsFromMovie {

   void onSuccess(List<MovieReview> movies);
   void onError();
}
