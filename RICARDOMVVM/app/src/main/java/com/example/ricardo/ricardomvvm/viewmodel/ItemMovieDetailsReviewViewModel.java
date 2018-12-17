package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieReview;

/**
 * Created by Ricardo on 15/12/2018
 */
public class ItemMovieDetailsReviewViewModel  extends ViewModel {

    private final MutableLiveData<MovieReview> movieReviewMutableLiveData = new MutableLiveData<>();

    public ItemMovieDetailsReviewViewModel() {
    }

    public final LiveData<MovieReview> getMovieReview(){
        LiveData<MovieReview> movieReview = Transformations.map(movieReviewMutableLiveData, movieR -> {
            return movieR;
        });
        return movieReview;
    }

    public final void setMovieReviewMutableLiveData(MovieReview movieReviewMutableLiveData){
        this.movieReviewMutableLiveData.setValue(movieReviewMutableLiveData);
    }


    public final LiveData<String> getAuthor(){
        LiveData<String> author = Transformations.map(movieReviewMutableLiveData, movieR -> {
            return movieR.getAuthor();
        });
        return author;
    }

    public final LiveData<String> getContent(){
        LiveData<String> content = Transformations.map(movieReviewMutableLiveData, movieR -> {
            return movieR.getContent();
        });
        return content;
    }



}
