package com.example.e5813.movieapp.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbClientInstance {

    private static Retrofit retrofit;

    final static String TMDB_BASE_URL = "https://api.themoviedb.org/3/";
    private static final String LANGUAGE = "en-US";

    final static String PARAM_API_KEY = "api_key";

    final static String API_KEY ="b7ecf52683a89db9aedbdc0ff9f31f25";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(TMDB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
