package com.example.e5813.movieapp.views.adapter.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.views.adapter.MovieAdapter;

public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final ImageView movieCoverImage;
final private MovieAdapter.MoviesAdapterOnClickHandler mClickHandler;

    /**
     *Um ViewHolder descreve uma visão de item e metadados sobre seu lugar dentro do RecyclerView.
     * @param itemView
     * @param handler
     */
    public MovieAdapterViewHolder(@NonNull View itemView, MovieAdapter.MoviesAdapterOnClickHandler handler) {
        super(itemView);
        mClickHandler = handler;
        movieCoverImage = (ImageView) itemView.findViewById(R.id.img_cover_movie);
        itemView.setOnClickListener(this);
    }

    /**
     * Usado pelas childs views durante o click
     * @param v
     */

    @Override
    public void onClick(View v) {
        int adatpterPosition = getAdapterPosition();
        mClickHandler.onClick(adatpterPosition );
    }
}
