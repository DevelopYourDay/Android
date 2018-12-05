package com.example.e5813.movieapp.networks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.e5813.movieapp.R;

import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMovieTopRated;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMoviesCallback;
import com.example.e5813.movieapp.networks.Interfaces.TmdbApiService;
import com.example.e5813.movieapp.views.adapter.MovieAdapter;
import com.example.e5813.movieapp.views.notifications.Toasts;

import java.util.LinkedList;
import java.util.List;

public class FetchMovies {

    private  Context context;


    public FetchMovies(Context context) {
        this.context = context;
    }

    /**
     * Fetech Movies sorted by Popular
     */
    public void getMovieListByPopular(){
        final TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);


        AsyncTask task = new AsyncTask( ) {
            @Override
            protected Object doInBackground(Object[] objects) {

                MoviesRepository.getMovies(api, new OnGetMoviesCallback() {
                    @Override
                    public void onSuccess(List<Movie> movies) {
                        //mMovieAdapter = new MovieAdapter(context, mMoviesAdapterOnClickHandler, movies);
                        //mRecyclerView.setAdapter(mMovieAdapter);
                    }

                    @Override
                    public void onError() {
                        Toast toast = new Toasts().NoInternetConnection(context);
                        toast.show();
                    }
                });
            }
        };


    }

    /**
     * Fetech moveis sorted by Top Rated
     */
    public void  getMovieListByTopRated(){
        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MoviesRepository.getMoviesTopRated(api, new OnGetMovieTopRated() {
            @Override
            public void onSuccess(List<Movie> movies) {
                //mMovieAdapter = new MovieAdapter(context, mMoviesAdapterOnClickHandler, movies);
                //mRecyclerView.setAdapter(mMovieAdapter);
            }
            @Override
            public void onError() {
                Toast toast = new Toasts().NoInternetConnection(context);
                toast.show();
            }
        });
    }
}
