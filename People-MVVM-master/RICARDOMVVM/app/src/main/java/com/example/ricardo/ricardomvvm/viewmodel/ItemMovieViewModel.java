package com.example.ricardo.ricardomvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.ricardo.ricardomvvm.MovieUtils;
import com.example.ricardo.ricardomvvm.model.Movie;
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

    @BindingAdapter("imageUrl")
    public static void setImageURl (ImageView imageView, String url){
        Picasso.get().load(MovieUtils.getFullUrlImage(url)).into(imageView);
    }

    public void onItemClick(View view) {
        //context.startActivity(PeopleDetailActivity.launchDetail(view.getContext(), people));
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        notifyChange();
    }
}
