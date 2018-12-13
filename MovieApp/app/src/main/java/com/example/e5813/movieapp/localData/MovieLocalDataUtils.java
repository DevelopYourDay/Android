package com.example.e5813.movieapp.localData;

import android.database.Cursor;

import com.example.e5813.movieapp.models.movies.Movie;
import com.example.e5813.movieapp.models.movies.MovieDetail;

public class MovieLocalDataUtils {


    public static  MovieDetail extractMovieDetailFromCursor(Cursor cursor){

        if(cursor.getCount() >=1){

            cursor.moveToFirst();

        int indexId = cursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID);
        int indexTitle = cursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_TITLE);
        int indexDuration = cursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_DURATION);
        int indexYear = cursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_YEAR);
        int indexRating = cursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_RATING);
        int indexDate = cursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_DATE);
        int indexUrlImage = cursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_URL_IMAGE);
        int indexDescription = cursor.getColumnIndex((MoviesContract.MoviesFavoritesEntry.COLUMN_DESCRIPTION));

        int id = cursor.getInt(indexId);
        String title = cursor.getString(indexTitle);
        String duration = cursor.getString(indexDuration);
        String year = cursor.getString(indexYear);
        String rating = cursor.getString(indexRating);
        String urlImage = cursor.getString(indexUrlImage);
        String description = cursor.getString(indexDescription);

        MovieDetail movieDetail =  new MovieDetail(id, title, year, duration, rating, description, urlImage);

        cursor.close();

        return movieDetail;
    }
        return null;
    }
}
