package com.example.e5813.movieapp.activities;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.utils.MovieUtils;
import com.squareup.picasso.Picasso;


import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapterViewHolder> {

    public interface MoviesAdapterOnClickHandler {
        void onClick(int id);
    }

    private List<Movie> mMovieList;
    private final Context mContext;
    final private MoviesAdapterOnClickHandler mClickHandler;

    public MovieAdapter(@NonNull Context context, MoviesAdapterOnClickHandler clickHandler, List<Movie> seriesList) {
        this.mContext = context;
        this.mClickHandler = clickHandler;
        this.mMovieList = seriesList;
    }

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layout = R.layout.movie_list_item;
        View view = LayoutInflater.from(mContext).inflate(layout,viewGroup,false);
        view.setFocusable(true);
        return new MovieAdapterViewHolder(view, mClickHandler);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        Picasso.get().load(MovieUtils.getFullUrlImage(movie.getUrlImage())).into(holder.movieCoverImage);
    }

    @Override
    public int getItemCount() {
        if(null == mMovieList) return 0;
        return mMovieList.size();
    }




}
