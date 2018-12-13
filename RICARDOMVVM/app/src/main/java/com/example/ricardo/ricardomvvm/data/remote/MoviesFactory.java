package com.example.ricardo.ricardomvvm.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesFactory {

    private static Retrofit retrofit;

    public final static String TMDB_BASE_URL = "https://api.themoviedb.org/3/";
    public final static String LANGUAGE = "en-US";
    public final static String API_KEY = "b7ecf52683a89db9aedbdc0ff9f31f25";

    public static MovieService create() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(TMDB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(MovieService.class);
    }

}
