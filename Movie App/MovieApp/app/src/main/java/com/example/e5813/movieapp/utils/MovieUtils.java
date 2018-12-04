package com.example.e5813.movieapp.utils;

public class MovieUtils {

    private static final String URL_BASE = "http://image.tmdb.org/t/p/";
    private static final String SIZE_IMAGE = "w185/";
    private static final String URL_BASE_LOAD_IMAGE = URL_BASE + SIZE_IMAGE;


    public static String getFullUrlImage(String urlImage){
        if(urlImage != null){
            String finalUrl = URL_BASE_LOAD_IMAGE + urlImage;
            return finalUrl;
        }
        return null;
    }


    public static String convertRatingPercentage(String rating){
        if(rating != null){
            String finalRating = rating + "/10";
            return finalRating;
        }
            return null;
    }


    public String getRuntimeInMinutes(String runtime){
        if(runtime != null){
            String runtimeFinal = runtime + "min";
            return runtimeFinal;
        }
        return null;
    }
}
