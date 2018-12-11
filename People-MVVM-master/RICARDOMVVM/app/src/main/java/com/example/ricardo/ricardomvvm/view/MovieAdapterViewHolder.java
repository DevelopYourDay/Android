package com.example.ricardo.ricardomvvm.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final ImageView movieCoverImage;
    ItemMovieBinding mItemMovieBinding;
final private MovieAdapter.MoviesAdapterOnClickHandler mClickHandler;

    /**
     *Um ViewHolder descreve uma visão de item e metadados sobre seu lugar dentro do RecyclerView.
     * @param itemView
     * @param handler
     */
    public MovieAdapterViewHolder(ItemPeopleBinding itemPeopleBinding) {
        super(itemPeopleBinding.itemMovie);
        mItemMovieBinding =itemPeopleBinding;
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
