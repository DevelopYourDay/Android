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


    public static String getDurationInMinutes(String duration){
        if(duration != null){
            String runtimeFinal = duration + "min";
            return runtimeFinal;
        }
        return null;
    }

    /**
     *  extract Year form date. o formato da date tem de ser YYYY-MM-DD
     * @param date format example 2018-10-03
     * @return 2018
     */
    public static String getYearFromDate(String date){
        if(date != null){
            String[] str = date.split("-");
            if(str[0].matches("\\d{4}"))
                return str[0];
        }
        return null;
    }
}
