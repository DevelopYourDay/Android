package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
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
public class ItemMovieViewModel extends ViewModel {


    private final MutableLiveData<Movie> movieMutableLiveData = new MutableLiveData<>();


    public ItemMovieViewModel() {
    }

    public final void setMovieMutableLiveData(Movie movie){
        this.movieMutableLiveData.setValue(movie);
    }

    public final LiveData<Integer> getIdMovie(){
        LiveData<Integer> idMovie = Transformations.map(movieMutableLiveData, movie -> {
            return movie.getId();
        });
        return idMovie;
    }

    public final LiveData<Movie> getMovie(){
        LiveData<Movie> movie = Transformations.map(movieMutableLiveData, moviee -> {
            return moviee;
        });
        return movie;
    }


    public final LiveData<String> getUrl() {
        LiveData<String> url = Transformations.map(movieMutableLiveData, movie -> {
            return MovieUtils.getFullUrlImage(movie.getUrlImage());
        });
        return url;
    }

    @BindingAdapter({"imageUrls"})
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }


    public void onItemClick(View view) {
        view.getContext().startActivity(MovieDetailsActivity.launchDetail(view.getContext(), movieMutableLiveData.getValue()));
    }

}
