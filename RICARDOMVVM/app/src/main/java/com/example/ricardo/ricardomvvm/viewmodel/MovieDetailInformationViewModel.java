package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.squareup.picasso.Picasso;

public class MovieDetailInformationViewModel extends ViewModel {

    private MutableLiveData<MovieDetail> currentMovieDetails = new MutableLiveData<>();




    public final void setCurrentMovieDetails(MovieDetail movieDetail){
        currentMovieDetails.setValue(movieDetail);
    }

    public final LiveData<String> getDuration(){
        LiveData<String> duration = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.getDurationInMinutes(movie.getDuration());
        });
        return duration;
    }

    public final LiveData<String>getYear(){
        LiveData<String> year = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.getYearFromDate(movie.getYear());
        });
        return year;
    }

    public final LiveData<String>getRating(){
        LiveData<String> rating = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.convertRatingPercentage(movie.getRating());
        });
        return rating;
    }


    public final LiveData<String>getDescription(){
        LiveData<String> description = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.convertRatingPercentage(movie.getRating());
        });
        return description;
    }

    @BindingAdapter({"imageUrl"})
    public void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(MovieUtils.getFullUrlImage(imageUrl)).into(view);
    }

}
