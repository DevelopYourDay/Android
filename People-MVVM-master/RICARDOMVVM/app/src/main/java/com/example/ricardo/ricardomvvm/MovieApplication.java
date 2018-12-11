package com.example.ricardo.ricardomvvm;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.ricardo.ricardomvvm.data.remote.MovieService;
import com.example.ricardo.ricardomvvm.data.remote.MoviesFactory;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ricardo on 10/12/2018
 */
public class MovieApplication extends MultiDexApplication {
    private MovieService movieService;
    private Scheduler scheduler;
    private static MovieApplication mInstance;

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


    /// next 3 method is user to check internet connections
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MovieApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

}
