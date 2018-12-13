package com.example.e5813.movieapp.localData;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class MoviesProvider extends ContentProvider {


    public static final int CODE_ALL_FAVORITES_MOVIES = 100;
    public static final int CODE_FAVORITES_MOVIES_ID = 101;
    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private MoviesDbHelper mOpenHelper;


    public static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = MoviesContract.CONTENT_AUTHORITY;
        matcher.addURI(authority, MoviesContract.PATH_MOVIES, CODE_ALL_FAVORITES_MOVIES);
        matcher.addURI(authority, MoviesContract.PATH_MOVIES + "/#", CODE_FAVORITES_MOVIES_ID);
        return matcher;
    }


    @Override
    public boolean onCreate() {
        mOpenHelper = new MoviesDbHelper(getContext());
        return true;
    }


    //select
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor;

        switch (sUriMatcher.match(uri)) {
            case CODE_FAVORITES_MOVIES_ID: {
                String normalizedUtcDateString = uri.getLastPathSegment();
                String[] selectionArguments = new String[]{normalizedUtcDateString};
                cursor = mOpenHelper.getReadableDatabase().query(
                        /* Table we are going to query */
                        MoviesContract.MoviesFavoritesEntry.TABLE_NAME,
                        projection,
                        MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID + " = ? ",
                        selectionArguments,
                        null,
                        null,
                        sortOrder);
                break;
            }
            case CODE_ALL_FAVORITES_MOVIES: {
                cursor = mOpenHelper.getWritableDatabase().query(
                        MoviesContract.MoviesFavoritesEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);

                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case CODE_ALL_FAVORITES_MOVIES:
                return "ssssss";
            case CODE_FAVORITES_MOVIES_ID:
                return "aaaaa";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = mOpenHelper.getWritableDatabase().insert(MoviesContract.MoviesFavoritesEntry.TABLE_NAME, null, values);
        if (rowID > 0) {
            //Uri _uri = ContentUris.withAppendedId(MoviesContract.MoviesFavoritesEntry.CONTENT_URI, rowID);
            //getContext().getContentResolver().notifyChange(_uri, null);

            return Uri.parse(MoviesContract.MoviesFavoritesEntry.CONTENT_URI + "/" + rowID);
        }

        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (sUriMatcher.match(uri)) {
            case CODE_ALL_FAVORITES_MOVIES:
                count = mOpenHelper.getWritableDatabase().delete(MoviesContract.MoviesFavoritesEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case CODE_FAVORITES_MOVIES_ID:
                String id = uri.getPathSegments().get(1);
                count = mOpenHelper.getWritableDatabase().delete(MoviesContract.MoviesFavoritesEntry.TABLE_NAME,
                        MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID + " = " + id +
                                (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:

                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return count;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;
        switch (sUriMatcher.match(uri)) {
            case CODE_ALL_FAVORITES_MOVIES:
                count = mOpenHelper.getWritableDatabase().update(MoviesContract.MoviesFavoritesEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case CODE_FAVORITES_MOVIES_ID:
                count = mOpenHelper.getWritableDatabase().update(MoviesContract.MoviesFavoritesEntry.TABLE_NAME, values,
                        MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID + " = " + uri.getPathSegments().get(1) +
                                (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        return count;
    }

    @Override
    public void shutdown() {
        mOpenHelper.close();
        super.shutdown();
    }

}
