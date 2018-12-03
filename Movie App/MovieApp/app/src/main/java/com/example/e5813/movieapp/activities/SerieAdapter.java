package com.example.e5813.movieapp.activities;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Serie;
import com.example.e5813.movieapp.utils.DownloadImageTask;

import java.util.List;

public class SerieAdapter  extends RecyclerView.Adapter<SerieAdapterViewHolder> {

    public interface SeriesAdapterOnClickHandler {
        void onClick(int id);
    }

    private List<Serie> mSeriesList;

    private final Context mContext;

    final private SeriesAdapterOnClickHandler mClickHandler;

    private Cursor mCursor;


    public SerieAdapter(@NonNull Context context, SeriesAdapterOnClickHandler clickHandler, List<Serie> seriesList) {
        this.mContext = context;
        this.mClickHandler = clickHandler;
        this.mSeriesList = seriesList;
    }


    @NonNull
    @Override
    public SerieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layout = R.layout.movie_list_item;
        View view = LayoutInflater.from(mContext).inflate(layout,viewGroup,false);
        view.setFocusable(true);
        return new SerieAdapterViewHolder(view, mClickHandler);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieAdapterViewHolder holder, int position) {
        Serie serie = mSeriesList.get(position);
        holder.serieName.setText(serie.getName());
        holder.descriptionSerie.setText(serie.getSecoundName());
        new DownloadImageTask((ImageView) holder.coverSerieView).execute(serie.getUrlImage());
    }

    @Override
    public int getItemCount() {
        if(null == mSeriesList) return 0;
        return mSeriesList.size();
    }


}
