package com.example.e5813.movieapp.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e5813.movieapp.R;

import org.w3c.dom.Text;

public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

final ImageView movieCoverImage;
final private MovieAdapter.MoviesAdapterOnClickHandler mClickHandler;


    public MovieAdapterViewHolder(@NonNull View itemView, MovieAdapter.MoviesAdapterOnClickHandler handler) {
        super(itemView);
        mClickHandler = handler;
        movieCoverImage = (ImageView) itemView.findViewById(R.id.img_cover_movie);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int adatpterPosition = getAdapterPosition();
        mClickHandler.onClick(v.getId()); // necessario alterar aqui
    }
}
