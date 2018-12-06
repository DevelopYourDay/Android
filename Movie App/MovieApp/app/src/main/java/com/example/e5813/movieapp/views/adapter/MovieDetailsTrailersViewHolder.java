package com.example.e5813.movieapp.views.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.e5813.movieapp.R;

public class MovieDetailsTrailersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    final private MovieDetailsTrailerAdapter.MovieDetailsTrailerAdapterOnClickHandler mClickHandler;
    final TextView mTxtNameTrailer;

    public MovieDetailsTrailersViewHolder(@NonNull View itemView, MovieDetailsTrailerAdapter.MovieDetailsTrailerAdapterOnClickHandler handler) {
        super(itemView);
        mClickHandler = handler;
        mTxtNameTrailer = (TextView) itemView.findViewById(R.id.tv_list_trailer_name_trailer);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int adatpterPosition = getAdapterPosition();
        mClickHandler.onClickTrailer(adatpterPosition );
    }
}
