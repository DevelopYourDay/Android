package com.example.e5813.movieapp.activities;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e5813.movieapp.R;

import org.w3c.dom.Text;

public class SerieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

final ImageView coverSerieView;
final TextView serieName;
final TextView descriptionSerie;
final ImageView addSerieFavoriteView;
final private SerieAdapter.SeriesAdapterOnClickHandler mClickHandler;


    public SerieAdapterViewHolder(@NonNull View itemView, SerieAdapter.SeriesAdapterOnClickHandler handler) {
        super(itemView);
        mClickHandler = handler;
        coverSerieView = (ImageView) itemView.findViewById(R.id.img_serie);
        serieName = (TextView) itemView.findViewById(R.id.tv_name);
        descriptionSerie = (TextView) itemView.findViewById(R.id.tv_ep_and_temp);
        addSerieFavoriteView = (ImageView) itemView.findViewById(R.id.img_add_serie_favorites);
        itemView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int adatpterPosition = getAdapterPosition();
        mClickHandler.onClick(v.getId()); // necessario alterar aqui

    }
}
