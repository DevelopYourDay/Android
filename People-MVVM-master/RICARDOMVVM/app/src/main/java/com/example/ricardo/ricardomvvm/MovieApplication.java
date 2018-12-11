package com.example.ricardo.ricardomvvm;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.ricardo.ricardomvvm.data.MovieService;
import com.example.ricardo.ricardomvvm.data.MoviesFactory;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ricardo on 10/12/2018
 */
public class MovieApplication extends MultiDexApplication {
    private MovieService movieService;
    private Scheduler scheduler;

    private static MovieApplication get(Context context) {
        return (MovieApplication) context.getApplicationContext();
    }

    public static MovieApplication create(Context context) {
        return MovieApplication.get(context);
    }

    public MovieService getMovieService() {
        if (movieService == null) {
            movieService = MoviesFactory.create();
        }

        return movieService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setPeopleService(MovieService movieService) {
        this.movieService = movieService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
