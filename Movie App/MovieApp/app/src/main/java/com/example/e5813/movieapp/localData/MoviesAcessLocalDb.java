package com.example.e5813.movieapp.localData;

import android.content.Context;
import android.database.Cursor;

import com.example.e5813.movieapp.models.movies.MovieDetail;

public class MoviesAcessLocalDb {


    public static boolean IsPresentInFavoriteList(int idMovie, Context context){
        Cursor mCursor;
        String[] mProjection = {"*"};

        String mSelectionClause = MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID + " = ?";

        String[]  mSelectionArgs = {Integer.toString(idMovie)};

        mCursor = context.getContentResolver().query(MoviesContract.MoviesFavoritesEntry.buildMovieUriWithIDMovie(idMovie), mProjection,
                mSelectionClause, mSelectionArgs, null);

        if (mCursor.getCount() >= 1) {
            return true;
        }
        return false;
    }


    public  static MovieDetail getMovieDetail(int idMovie, Context context){
        Cursor mCursor;
        String[] mProjection = {"*"};

        String mSelectionClause = MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID + " = ?";

        String[]  mSelectionArgs = {Integer.toString(idMovie)};

        mCursor = context.getContentResolver().query(MoviesContract.MoviesFavoritesEntry.buildMovieUriWithIDMovie(idMovie), mProjection,
                mSelectionClause, mSelectionArgs, null);

        return MovieLocalDataUtils.extractMovieDetailFromCursor(mCursor);
    }

    public  static int removeMovieFromFavoriteList(int idMovie, Context context){
        String mSelectionClause = MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID + " = ?";
        String[]  mSelectionArgs = {Integer.toString(idMovie)};
        int numberOfRowDeleted = context.getContentResolver().delete(MoviesContract.MoviesFavoritesEntry.buildMovieUriWithIDMovie(idMovie),mSelectionClause,mSelectionArgs);
        return numberOfRowDeleted;
    }



}
