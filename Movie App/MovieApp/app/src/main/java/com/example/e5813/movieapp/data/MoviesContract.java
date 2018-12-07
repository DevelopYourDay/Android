package com.example.e5813.movieapp.data;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.e5813.movieapp.utils.MoviesDatesUtils;

public class MoviesContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.PopMovies";
    public static final String PATH_MOVIES = "movies";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final class MoviesFavoritesEntry implements BaseColumns {

        /* The base CONTENT_URI used to query the Weather table from the content provider */
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_MOVIES)
                .build();


        public static final String TABLE_NAME = "FavoritesMovies";

        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_URL_IMAGE = "urlImage";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_RATING = "rating";


        public static Uri buildWeatherUriWithDate(long date) {
            return CONTENT_URI.buildUpon()
                    .appendPath(Long.toString(date))
                    .build();
        }

        public static Uri buildMovieUriWithIDMovie(int id) {
            return CONTENT_URI.buildUpon()
                    .appendPath(Integer.toString(id))
                    .build();
        }


        public static String getSqlSelectForTodayOnwards() {
            long normalizedUtcNow = MoviesDatesUtils.normalizeDate(System.currentTimeMillis());
            return MoviesContract.MoviesFavoritesEntry.COLUMN_DATE + " >= " + normalizedUtcNow;
        }
    }
}
