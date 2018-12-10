package com.example.e5813.movieapp.localData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.e5813.movieapp.localData.MoviesContract.MoviesFavoritesEntry;

public class MoviesDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "movies.db";

    private static final int DATABASE_VERSION = 1;

    public MoviesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_FAVORITES_MOVIES_TABLE =  " CREATE TABLE " + MoviesFavoritesEntry.TABLE_NAME + " (" +
                MoviesFavoritesEntry._ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MoviesFavoritesEntry.COLUMN_DATE       + " INTEGER NOT NULL, "                 +
                MoviesFavoritesEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL,"                  +
                MoviesFavoritesEntry.COLUMN_TITLE   + " TEXT NOT NULL, "                    +
                MoviesFavoritesEntry.COLUMN_URL_IMAGE   + " TEXT NOT NULL, "                    +
                MoviesFavoritesEntry.COLUMN_YEAR  + " TEXT NOT NULL, "                    +
                MoviesFavoritesEntry.COLUMN_DURATION   + " TEXT NOT NULL, "                    +
                MoviesFavoritesEntry.COLUMN_RATING + " TEXT NOT NULL, "                    +
                MoviesFavoritesEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
        " UNIQUE (" + MoviesFavoritesEntry.COLUMN_MOVIE_ID + ") ON CONFLICT REPLACE);";

        db.execSQL(SQL_CREATE_FAVORITES_MOVIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + MoviesFavoritesEntry.TABLE_NAME+"'");
        onCreate(db);
    }
}
