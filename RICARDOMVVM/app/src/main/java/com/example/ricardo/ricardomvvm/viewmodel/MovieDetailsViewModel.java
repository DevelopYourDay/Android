package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
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

    private MutableLiveData<MovieDetail> movieDetail;
    public MutableLiveData<String> title = new MutableLiveData<>();
    private Movie movie;
    Context context ;


    public MovieDetailsViewModel(Movie movie, Context context) {
         this.context = context;
         this.movie = movie;
    }

    public MutableLiveData<MovieDetail> getMovieDetailLiveData(){
        if(movieDetail == null){
            movieDetail =  new MutableLiveData<>();
           fetchDetailMovie(this.movie);
        }
        return movieDetail;
    }





    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @BindingAdapter({"imageUrl"})
    public void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(MovieUtils.getFullUrlImage(imageUrl)).into(view);
    }


    public void fetchDetailMovie(final Movie movie) {

        MovieRepository.getDetailsFromMovie(context, movie.getId(), new GetDetailsFromMovie() {
            @Override
            public void onSuccess(MovieDetail movieDetail) {
                MovieDetailsViewModel.this.movieDetail.postValue(movieDetail);
                MovieDetailsViewModel.this.title.postValue(movieDetail.getTitle());
            }

            @Override
            public void onError() {
                Toast toast = Toasts.createToastNoInternetConnection(context);
                toast.show();
            }
        });
    }

}
