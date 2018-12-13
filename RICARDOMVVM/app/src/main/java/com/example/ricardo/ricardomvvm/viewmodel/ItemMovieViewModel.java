package com.example.ricardo.ricardomvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.view.MovieDetailsActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by Ricardo on 10/12/2018
 */
public class ItemMovieViewModel extends BaseObservable {
    private Movie movie;
    private Context context;

    public ItemMovieViewModel(Movie movie, Context context) {
        this.movie = movie;
        this.context = context;
    }

    public int getIdMovie(){
        return movie.getId();
    }

    public String getUrlImage(){
        return movie.getUrlImage();
    }


    public void onItemClick(View view) {
        context.startActivity(MovieDetailsActivity.launchDetail(view.getContext(), movie));
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        notifyChange();
    }
}
