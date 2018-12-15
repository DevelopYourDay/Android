package com.example.ricardo.ricardomvvm.Utils;

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
    private static Scheduler scheduler;
    private static MovieApplication mInstance;



    public static Scheduler subscribeScheduler() {
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
        listener.onNetworkConnectionChanged(ConnectivityReceiver.isConnected());
    }

}
