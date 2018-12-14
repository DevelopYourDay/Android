package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.data.remote.MovieRepository;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetDetailsFromMovie;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.example.ricardo.ricardomvvm.view.notifications.Toasts;
import com.squareup.picasso.Picasso;

public class MovieDetailsViewModel extends ViewModel {

    private MutableLiveData<MovieDetail> currentMovieDetails = new MutableLiveData<>();
    private Movie movie;
    private Context context;

    public MovieDetailsViewModel(Movie movie, Context context) {
        this.movie = movie;
        this.context = context;
        fetchDetailMovie(movie);
    }

    public final LiveData<MovieDetail>getMovieDetail(){
        return currentMovieDetails;
    }

    public final LiveData<String>getTitle(){
        LiveData<String> title = Transformations.map(currentMovieDetails, movie -> {
            return movie.getTitle();
        });
        return title;
    }


    public void fetchDetailMovie(final Movie movie) {

        MovieRepository.getDetailsFromMovie(context, movie.getId(), new GetDetailsFromMovie() {
            @Override
            public void onSuccess(MovieDetail movieDetail) {
                currentMovieDetails.setValue(movieDetail);
            }
            @Override
            public void onError() {
                Toast toast = Toasts.createToastNoInternetConnection(context);
                toast.show();
            }
        });
    }


}
