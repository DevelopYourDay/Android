package com.example.e5813.movieapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.networks.MoviesRepository;
import com.example.e5813.movieapp.networks.OnGetMovieDetails;

import com.example.e5813.movieapp.networks.TmdbApiService;
import com.example.e5813.movieapp.networks.TmdbClientInstance;
import com.example.e5813.movieapp.utils.MovieUtils;
import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {

    private static  final int DEFAULT_VALUE_EXTRA_ID = 1;
    private int mIdMovie;
    private MovieDetails mMovieDetails;
    private TextView mTitle;
    private TextView mYear;
    private TextView mDuration;
    private TextView mDescription;
    private TextView mRating;
    private ImageView mCover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Intent IntentListMovies = getIntent();
        if (IntentListMovies != null) {
            if (IntentListMovies.hasExtra(MovieList.PARCEL_MOVIE_ID)) {
                mIdMovie = IntentListMovies.getIntExtra(MovieList.PARCEL_MOVIE_ID,DEFAULT_VALUE_EXTRA_ID);
                getMovieDetails(mIdMovie);
            }
        }
    }

    public void loadViews(com.example.e5813.movieapp.models.MovieDetails mMovie ){

        mTitle = (TextView) findViewById(R.id.tv_movie_title);
        mYear = (TextView) findViewById(R.id.tv_movie_year);
        mDuration = (TextView) findViewById(R.id.tv_movie_duration);
        mDescription = (TextView) findViewById(R.id.tv_movie_descriptions);
        mRating = (TextView) findViewById(R.id.tv_movie_rating);
        mCover = (ImageView) findViewById(R.id.img_details_movie_cover);

        mTitle.setText(mMovie.getTitle());
        mYear.setText(MovieUtils.getYearFromDate(mMovie.getYear()));
        mDuration.setText(MovieUtils.getDurationInMinutes(mMovie.getDuration()));
        mDescription.setText(mMovie.getDescription());
        mRating.setText(MovieUtils.convertRatingPercentage(mMovie.getRating()));
        Picasso.get().load(MovieUtils.getFullUrlImage(mMovie.getUtlImage())).into(mCover);
    }


    private void  getMovieDetails(int idMovie){

        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MoviesRepository.getMoviesDetails(api, idMovie, new OnGetMovieDetails() {
            @Override
            public void onSuccess(com.example.e5813.movieapp.models.MovieDetails movieDetails) {
                loadViews(movieDetails);
            }

            @Override
            public void onError() {
                Toast.makeText(MovieDetails.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
