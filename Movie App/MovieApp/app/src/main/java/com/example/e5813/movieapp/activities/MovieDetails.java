package com.example.e5813.movieapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.models.MovieVideos;
import com.example.e5813.movieapp.networks.InternetCheckConnection.ConnectivityReceiver;
import com.example.e5813.movieapp.networks.InternetCheckConnection.MyApplication;
import com.example.e5813.movieapp.networks.MoviesRepository;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMovieDetails;

import com.example.e5813.movieapp.networks.Interfaces.TmdbApiService;
import com.example.e5813.movieapp.networks.TmdbClientInstance;
import com.example.e5813.movieapp.utils.MovieUtils;
import com.example.e5813.movieapp.views.adapter.MovieAdapter;
import com.example.e5813.movieapp.views.adapter.MovieDetailsTrailerAdapter;
import com.example.e5813.movieapp.views.notifications.Toasts;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class MovieDetails extends AppCompatActivity  implements ConnectivityReceiver.ConnectivityReceiverListener,
        MovieDetailsTrailerAdapter.MovieDetailsTrailerAdapterOnClickHandler{

    private static  final int DEFAULT_VALUE_EXTRA_ID = 1;
    private int mIdMovie;
    private MovieDetails mMovieDetails;
    private View mViewMovieInformation;
    private View mViewTrailers;
    private View mViewReviews;
    private View mViewNoInternet;
    private ScrollView scrollView_movie_details;
    private TextView mTitle;
    private TextView mYear;
    private TextView mDuration;
    private TextView mDescription;
    private TextView mRating;
    private ImageView mCover;

    private RecyclerView mRecyclerViewTrailers;
    private RecyclerView mRecyclerViewsReviews;
    private LinearLayoutManager mLinearLayoutManagerTrailers;
    private LinearLayoutManager mLinearLayoutManagerReviews;

    private MovieDetailsTrailerAdapter mMovieDetailsTrailerAdapter;

    private MovieDetailsTrailerAdapter.MovieDetailsTrailerAdapterOnClickHandler movieDetailsTrailerAdapterOnClickHandler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Intent IntentListMovies = getIntent();
        if (IntentListMovies != null) {
            if (IntentListMovies.hasExtra(MovieList.PARCEL_MOVIE_ID)) {
                mIdMovie = IntentListMovies.getIntExtra(MovieList.PARCEL_MOVIE_ID,DEFAULT_VALUE_EXTRA_ID);
                loadViews();
            }
        }
    }


    public void loadViews(){
        mViewMovieInformation = (View) findViewById(R.id.layout_fragment_list_movie_details);
        mViewTrailers = (View) findViewById(R.id.layout_fragment_list_trailer);
        mViewReviews = (View) findViewById(R.id.layout_fragment_list_reviews);
        mViewNoInternet = (View) findViewById(R.id.layout_movie_details_no_internet);
        scrollView_movie_details = (ScrollView) findViewById(R.id.scrollView_movie_details);

        mTitle = (TextView) mViewMovieInformation.findViewById(R.id.tv_movie_title);
        mYear = (TextView) mViewMovieInformation.findViewById(R.id.tv_movie_year);
        mDuration = (TextView) mViewMovieInformation.findViewById(R.id.tv_movie_duration);
        mDescription = (TextView) mViewMovieInformation.findViewById(R.id.tv_movie_descriptions);
        mRating = (TextView) mViewMovieInformation.findViewById(R.id.tv_movie_rating);
        mCover = (ImageView) mViewMovieInformation.findViewById(R.id.img_details_movie_cover);

        mRecyclerViewTrailers = (RecyclerView) mViewTrailers.findViewById(R.id.rv_list_trailers);
        mRecyclerViewsReviews = (RecyclerView) mViewReviews.findViewById(R.id.rv_list_reviews);


        // adapter and viewHolder para os trailers
        mLinearLayoutManagerTrailers = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewTrailers.setLayoutManager(mLinearLayoutManagerTrailers);
        mRecyclerViewTrailers.setHasFixedSize(true);
        movieDetailsTrailerAdapterOnClickHandler = this;
        //mfetchMovies = new FetchMovies(this);
        List<MovieVideos> listMovieTrailers = new LinkedList<>();
        mMovieDetailsTrailerAdapter = new MovieDetailsTrailerAdapter(this, movieDetailsTrailerAdapterOnClickHandler, listMovieTrailers);
        mRecyclerViewTrailers.setAdapter(mMovieDetailsTrailerAdapter);

    }

    private void setInformationToViews(com.example.e5813.movieapp.models.MovieDetails mMovie){
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
                setInformationToViews(movieDetails);
            }

            @Override
            public void onError() {
                createAndLoadToastNoInternetConnection();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        isConnected(ConnectivityReceiver.isConnected());
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        isConnected(ConnectivityReceiver.isConnected());
    }

    private void isConnected(boolean isConnected){
        if(isConnected){
            hiddeViewNoInternetConnection();
            getMovieDetails(mIdMovie);
            showAllViews();
        }else{
            hideAllViews();
            showViewNoInternetConnection();
        }
    }


    private void addTrailersToAdapter(){


    }

   private void hideAllViews(){
         mViewMovieInformation.setVisibility(View.INVISIBLE);
         mViewTrailers.setVisibility(View.INVISIBLE);
         mViewReviews.setVisibility(View.INVISIBLE);
   }

   private void showAllViews(){
        mViewMovieInformation.setVisibility(View.VISIBLE);
        mViewTrailers.setVisibility(View.VISIBLE);
        mViewReviews.setVisibility(View.VISIBLE);
    }

   private void showViewNoInternetConnection(){
        mViewNoInternet.setVisibility(View.VISIBLE);
   }

   private void hiddeViewNoInternetConnection(){
        mViewNoInternet.setVisibility(View.INVISIBLE);
   }

   private void createAndLoadToastNoInternetConnection(){
        Toast toast = new Toasts().NoInternetConnection(this);
        toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refres:
                isConnected(ConnectivityReceiver.isConnected());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClickTrailer(int id) {

    }
}
