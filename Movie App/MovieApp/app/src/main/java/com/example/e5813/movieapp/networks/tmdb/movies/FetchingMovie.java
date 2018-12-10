package com.example.e5813.movieapp.networks.tmdb.movies;

import android.content.Context;

import com.example.e5813.movieapp.models.movies.Movie;
import com.example.e5813.movieapp.models.movies.MovieDetail;
import com.example.e5813.movieapp.models.movies.MovieReview;
import com.example.e5813.movieapp.models.movies.MovieTrailler;
import com.example.e5813.movieapp.networks.tmdb.TmdbClientInstance;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetDetailsFromMovie;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetPopularMovies;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetReviewsFromMovie;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetTopRatedMovies;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetTraillersFromMovie;
import com.example.e5813.movieapp.networks.tmdb.interfaces.TmdbApiService;
import com.example.e5813.movieapp.views.adapter.MovieAdapter;
import com.example.e5813.movieapp.views.adapter.MovieDetailsReviewsAdapter;
import com.example.e5813.movieapp.views.adapter.MovieDetailsTrailerAdapter;
import com.example.e5813.movieapp.views.notifications.Toasts;

import java.util.List;

/**
 * Created by Ricardo on 08/12/2018
 */
public class FetchingMovie {

    /**
     * flag that we will use to determine if we are currently fetching the next page.
     * Without this flag, if the we scrolled 50% above it will fetch the same page multiple times and causes duplication.
     * Try commenting out this flag and you will notice that when you scroll, you will see the same movies of next page again and again.
     */
    private boolean isFetchingMovies;

    /**
     * Initialized to page 1.
     * Every time we scrolled half of the list we increment it by one which is the next page.
     */
    private int currentPage;

    public FetchingMovie(boolean isFetchingMovies, int currentPage) {
        this.isFetchingMovies = isFetchingMovies;
        this.currentPage = currentPage;
    }

    public FetchingMovie() {
    }

    public boolean getFetchingMovies() {
        return isFetchingMovies;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setFetchingMovies(boolean fetchingMovies) {
        isFetchingMovies = fetchingMovies;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


    public void getPopularMovies(final MovieAdapter adapter, final Context context) {
        isFetchingMovies = true;
        final TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MovieRepository.getPopularMovies(api, currentPage, new GetPopularMovies() {
            @Override
            public void onSuccess(int page, List<Movie> movies) {
                adapter.appendMovies(movies);
                currentPage = page;
                isFetchingMovies = false;
            }

            @Override
            public void onError() {
                Toasts.NoInternetConnectionToast(context);
            }
        });
    }

    /**
     * Fetech moveis sorted by Top Rated
     */
    public void getTopRatedMovies(final MovieAdapter adapter, final Context context) {
        isFetchingMovies = true;
        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MovieRepository.getTopRatedMovies(api, currentPage, new GetTopRatedMovies() {
            @Override
            public void onSuccess(int page, List<Movie> movies) {
                adapter.appendMovies(movies);
                currentPage = page;
                isFetchingMovies = false;
            }

            @Override
            public void onError() {
                Toasts.NoInternetConnectionToast(context);
            }
        });
    }

    private void getTrailersFromMovie(int movieID, final MovieDetailsTrailerAdapter adapter, final Context context) {
        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MovieRepository.getTrailersFromMovies(api, movieID, new GetTraillersFromMovie() {
            @Override
            public void onSuccess(List<MovieTrailler> movieVideos) {
                adapter.appendMovies(movieVideos);
            }

            @Override
            public void onError() {
                Toasts.NoInternetConnectionToast(context);
            }
        });
    }


    private void getReviewsFromMovie(int movieID, final MovieDetailsReviewsAdapter adapter, final Context context) {
        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MovieRepository.getReviewsFromMovie(api, movieID, new GetReviewsFromMovie() {
            @Override
            public void onSuccess(List<MovieReview> movieReviews) {
                adapter.appendReviews(movieReviews);
            }

            @Override
            public void onError() {
                Toasts.NoInternetConnectionToast(context);
            }
        });
    }


    private void  getMovieDetails(int idMovie,final Context context){
        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
         MovieDetail m;
        MovieRepository.getDetailsFromMovie(api, idMovie, new GetDetailsFromMovie() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(MovieDetail movieDetails) {

            }
        });
    }



}
