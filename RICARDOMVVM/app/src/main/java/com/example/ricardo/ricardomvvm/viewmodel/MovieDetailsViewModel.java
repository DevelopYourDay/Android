package com.example.ricardo.ricardomvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.data.remote.MovieRepository;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetDetailsFromMovie;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetReviewsFromMovie;
import com.example.ricardo.ricardomvvm.data.remote.interfacesMoviesServices.GetTraillersFromMovie;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.example.ricardo.ricardomvvm.model.MovieReview;
import com.example.ricardo.ricardomvvm.model.MovieTrailler;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieDetailsViewModel extends ViewModel {

    private MutableLiveData<MovieDetail> currentMovieDetails = new MutableLiveData<>();
    private final MutableLiveData<Movie> movie = new MutableLiveData<>();
    private final MutableLiveData<List<MovieReview>> movieReviewResponse = new MutableLiveData<>();
    private final MutableLiveData<List<MovieTrailler>> movieTrailersResponse = new MutableLiveData<>();
    private final MutableLiveData<Boolean> notificationNoInternet = new MutableLiveData<>();

    public final LiveData<Boolean> getnotifications() {
        return notificationNoInternet;
    }

    public final LiveData<List<MovieReview>> getListMovieReview(){
        return movieReviewResponse;
    }

    public final LiveData<MovieDetail> getMovieDetail() {
        return currentMovieDetails;
    }

    public final LiveData<String> getTitle() {
        LiveData<String> title = Transformations.map(currentMovieDetails, movie -> {
            return movie.getTitle();
        });
        return title;
    }

    public void setMovie(Movie movie) {
        this.movie.setValue(movie);
    }

    public final void setCurrentMovieDetails(MovieDetail movieDetail) {
        currentMovieDetails.setValue(movieDetail);
    }

    public final LiveData<String> getDuration() {
        LiveData<String> duration = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.getDurationInMinutes(movie.getDuration());
        });
        return duration;
    }

    public final LiveData<String> getYear() {
        LiveData<String> year = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.getYearFromDate(movie.getYear());
        });
        return year;
    }

    public final LiveData<String> getRating() {
        LiveData<String> rating = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.convertRatingPercentage(movie.getRating());
        });
        return rating;
    }


    public final LiveData<String> getDescription() {
        LiveData<String> description = Transformations.map(currentMovieDetails, movie -> {
            return movie.getDescription();
        });
        return description;
    }


    public final LiveData<String> getUrl() {
        LiveData<String> url = Transformations.map(currentMovieDetails, movie -> {
            return MovieUtils.getFullUrlImage(movie.getUtlImage());
        });
        return url;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }


    public void fetchDetailMovie() {

        MovieRepository.getDetailsFromMovie(movie.getValue().getId(), new GetDetailsFromMovie() {
            @Override
            public void onSuccess(MovieDetail movieDetail) {
                currentMovieDetails.setValue(movieDetail);
            }

            @Override
            public void onError() {
                notificationNoInternet.setValue(true);
            }
        });
    }


    public void fetchReviewsFromDetailMovie() {

        MovieRepository.getReviewsFromDetailsMovie(movie.getValue().getId(), new GetReviewsFromMovie() {
            @Override
            public void onSuccess(List<MovieReview> listMovieReviews) {
                movieReviewResponse.setValue(listMovieReviews);
            }

            @Override
            public void onError() {
                notificationNoInternet.setValue(true);
            }
        });
    }

    public void fetchTrailersFromDetailMovie() {

        MovieRepository.getTrailersFromDetailsMovie(movie.getValue().getId(), new GetTraillersFromMovie() {
            @Override
            public void onSuccess(List<MovieTrailler> listTrailer) {
                movieTrailersResponse.setValue(listTrailer);
            }

            @Override
            public void onError() {
                notificationNoInternet.setValue(true);
            }
        });
    }


}
