package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.data.remote.MovieRepository;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetDetailsFromMovie;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.example.ricardo.ricardomvvm.view.notifications.Toasts;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBinding;
import com.squareup.picasso.Picasso;


import io.reactivex.disposables.CompositeDisposable;

public class MovieDetailsViewModel {

    private Movie movie;
    public MutableLiveData<MovieDetail> movieDetail;
    private Context context;
    ActivityMovieDetailsBinding activityMovieDetailsBinding;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MovieDetailsViewModel(Movie movie, Context context) {
        this.movie = movie;
        this.context = context;
        movieDetail =  new MutableLiveData<>();
        fetchDetailMovie(movie);
    }

    public String getTitle(){
        if(this.movieDetail == null){
            this.movieDetail = new MutableLiveData<>();
            return movieDetail.getValue().getTitle();
        }else{
            return this.movieDetail.getValue().getTitle();
        }

    }

    public MovieDetail getMovieDetails(){
        if(this.movieDetail == null){
            this.movieDetail = new MutableLiveData<>();
            return movieDetail.getValue();
        }else{
            return this.movieDetail.getValue();
        }

    }

    @BindingAdapter({"imageUrl"})
    public void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(MovieUtils.getFullUrlImage(imageUrl)).into(view);
    }


    private void fetchDetailMovie(Movie movie) {

        MovieRepository.getDetailsFromMovie(context, compositeDisposable, movie.getId(), new GetDetailsFromMovie() {
            @Override
            public void onSuccess(MovieDetail movieDetail) {
                setMovieDetails(movieDetail);
            }
            @Override
            public void onError() {
                Toast toast = Toasts.createToastNoInternetConnection(context);
                toast.show();
            }
        });
    }

    private void setMovieDetails(MovieDetail movieDetails){
        this.movieDetail.postValue(movieDetails);
    }

}
