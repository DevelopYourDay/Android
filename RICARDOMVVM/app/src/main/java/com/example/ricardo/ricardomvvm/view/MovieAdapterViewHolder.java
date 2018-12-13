package com.example.ricardo.ricardomvvm.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.ricardo.ricardomvvm.databinding.MovieListItemBinding;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel;

public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {

    MovieListItemBinding mItemMovieBinding;


    public MovieAdapterViewHolder(MovieListItemBinding itemMovieBinding) {
        super(itemMovieBinding.getRoot());
        mItemMovieBinding = itemMovieBinding;
    }


    void bindMovie(Movie movie) {
        if (mItemMovieBinding.getMovieItemViewModel() == null) {
            mItemMovieBinding.setMovieItemViewModel(
                    new ItemMovieViewModel(movie, itemView.getContext()));
        } else {
            mItemMovieBinding.getMovieItemViewModel().setMovie(movie);
        }
    }
}
