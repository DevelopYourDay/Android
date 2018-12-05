package com.example.e5813.movieapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.networks.MoviesRepository;
import com.example.e5813.movieapp.networks.OnGetMoviesCallback;
import com.example.e5813.movieapp.networks.TmdbApiService;
import com.example.e5813.movieapp.networks.TmdbClientInstance;

import java.util.List;


public class MovieList extends AppCompatActivity implements MovieAdapter.MoviesAdapterOnClickHandler{

    public static final String PARCEL_MOVIE_ID = "PARCEL_MOVIE_ID";
    private RecyclerView mRecyclerView;
    private ProgressBar mLoadingIndicator;
    private MovieAdapter mMovieAdapter;
    private MovieAdapter.MoviesAdapterOnClickHandler moviesAdapterOnClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_movies);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.widget_progress_bar_list_series);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        moviesAdapterOnClickHandler =  this;
    }


    @Override
    protected void onStart() {
        getMovieList();
        super.onStart();
    }

    private void  getMovieList(){

        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MoviesRepository.getMovies(api, new OnGetMoviesCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                showLoading();
                mMovieAdapter = new MovieAdapter(MovieList.this, moviesAdapterOnClickHandler, movies);
                mRecyclerView.setAdapter(mMovieAdapter);
                showSerieDataView();
            }

            @Override
            public void onError() {
                Toast.makeText(MovieList.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showLoading() {
        /* Then, hide the weather data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        /* Finally, show the loading indicator */
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    private void showSerieDataView() {
        /* First, hide the loading indicator */
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        /* Finally, make sure the weather data is visible */
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(int id) {
        Intent movieDetailIntent = new Intent(MovieList.this,MovieDetails.class);
        Movie movie = mMovieAdapter.getMovieFromList(id);
         movieDetailIntent.putExtra(PARCEL_MOVIE_ID, movie.getId());
        startActivity(movieDetailIntent);
    }
}
