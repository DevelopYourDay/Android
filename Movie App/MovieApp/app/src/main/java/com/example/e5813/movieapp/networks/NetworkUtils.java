package com.example.e5813.movieapp.networks;

import android.net.Uri;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {

    final static String TMDB_BASE_URL = "https://api.themoviedb.org/3";
    final static String PARAM_API_KEY = "api_key";

    final static String API_KEY ="b7ecf52683a89db9aedbdc0ff9f31f25";

    final static String URL_GET_TV_POPULAR = TMDB_BASE_URL + "/tv/popular";





    public static  URL buildURLToGetTvPoPular(){
            Uri builtUri = Uri.parse(URL_GET_TV_POPULAR).buildUpon()
                    .appendQueryParameter(PARAM_API_KEY, API_KEY)
                    .build();
            URL url = null;
            try {
                url = new URL(builtUri.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return url;
    }

    public static String getResponseFromGetTvPopular() throws IOException{
        URL url =  NetworkUtils.buildURLToGetTvPoPular();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try{


        }finally {
            urlConnection.disconnect();
        }





    }
}
