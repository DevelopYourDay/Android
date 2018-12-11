package com.example.ricardo.ricardomvvm;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * Created by Ricardo on 10/12/2018
 */
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

    /**
     *  add "/10" to rating
     * @param rating example "6.5"
     * @return "6.5/10"
     */
    public static String convertRatingPercentage(String rating){
        if(rating != null){
            String finalRating = rating + "/10";
            return finalRating;
        }
        return null;
    }


    /**
     * add "min" to duration
     * @param duration example "112"
     * @return "112min"
     */
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


    public static void watchYoutubeVideo(Context context, String keyMovie){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + keyMovie));
        try {
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(appIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            // Start an activity if it's safe
            if (isIntentSafe) {
                context.startActivity(appIntent);
            }
            // context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(appIntent);
        }
    }
}
