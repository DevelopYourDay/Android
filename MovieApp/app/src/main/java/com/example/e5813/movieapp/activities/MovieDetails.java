package com.example.e5813.movieapp.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.localData.MoviesAcessLocalDb;
import com.example.e5813.movieapp.localData.MoviesContract;
import com.example.e5813.movieapp.models.movies.MovieDetail;
import com.example.e5813.movieapp.models.movies.Movie;
import com.example.e5813.movieapp.models.movies.MovieReview;
import com.example.e5813.movieapp.models.movies.MovieTrailler;
import com.example.e5813.movieapp.networks.InternetCheckConnection.ConnectivityReceiver;
import com.example.e5813.movieapp.networks.InternetCheckConnection.MyApplication;
import com.example.e5813.movieapp.networks.tmdb.TmdbClientInstance;
import com.example.e5813.movieapp.networks.tmdb.interfaces.GetDetailsFromMovie;
import com.example.e5813.movieapp.networks.tmdb.interfaces.TmdbApiService;
import com.example.e5813.movieapp.networks.tmdb.movies.FetchingMovie;

import com.example.e5813.movieapp.networks.tmdb.movies.MovieRepository;
import com.example.e5813.movieapp.utils.MovieUtils;
import com.example.e5813.movieapp.utils.MoviesDatesUtils;
import com.example.e5813.movieapp.views.adapter.MovieDetailsReviewsAdapter;
import com.example.e5813.movieapp.views.adapter.MovieDetailsTrailerAdapter;
import com.example.e5813.movieapp.views.notifications.Toasts;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class MovieDetails extends AppCompatActivity  implements ConnectivityReceiver.ConnectivityReceiverListener,
        MovieDetailsTrailerAdapter.MovieDetailsTrailerAdapterOnClickHandler,
        MovieDetailsReviewsAdapter.MovieDetailsReviewsAdapterOnClickHandler {

    private static  final int DEFAULT_VALUE_EXTRA_ID = 1;
    private Movie mIdMovie;
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
    private ImageView mBtAddFavorites;

    private RecyclerView mRecyclerViewTrailers;
    private RecyclerView mRecyclerViewsReviews;
    private LinearLayoutManager mLinearLayoutManagerTrailers;
    private LinearLayoutManager mLinearLayoutManagerReviews;

    private boolean movieIsPresentInFavoriteListOnLocalDB = false;

    private MovieDetailsTrailerAdapter mMovieDetailsTrailerAdapter;
    private MovieDetailsReviewsAdapter mMovieDetailsReviewsAdapter;

    private FetchingMovie fetchingMovie;

    private MovieDetailsTrailerAdapter.MovieDetailsTrailerAdapterOnClickHandler movieDetailsTrailerAdapterOnClickHandler;
    private  MovieDetailsReviewsAdapter.MovieDetailsReviewsAdapterOnClickHandler movieDetailsReviewsAdapterOnClickHandler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Intent IntentListMovies = getIntent();
        if (IntentListMovies != null) {
            if (IntentListMovies.hasExtra(MovieList.PARCEL_MOVIE_ID)) {
                fetchingMovie =  new FetchingMovie();
                mIdMovie = (Movie)IntentListMovies.getSerializableExtra(MovieList.PARCEL_MOVIE_ID);
                movieIsPresentInFavoriteListOnLocalDB = MoviesAcessLocalDb.IsPresentInFavoriteList(mIdMovie.getId(),this);
                loadViews();
                isConnected(ConnectivityReceiver.isConnected());
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
        mBtAddFavorites = (ImageView) mViewMovieInformation.findViewById(R.id.img_details_movie_mark_favorite);
        actionBtnAddMovieFavoriteList(mBtAddFavorites);
        defineIconBtnFavorite(mIdMovie.getId());

        mRecyclerViewTrailers = (RecyclerView) mViewTrailers.findViewById(R.id.rv_list_trailers);
        mRecyclerViewsReviews = (RecyclerView) mViewReviews.findViewById(R.id.rv_list_reviews);


        // adapter and viewHolder para os trailers
        mLinearLayoutManagerTrailers = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewTrailers.setLayoutManager(mLinearLayoutManagerTrailers);
        mRecyclerViewTrailers.setHasFixedSize(true);
        movieDetailsTrailerAdapterOnClickHandler = this;
        mMovieDetailsTrailerAdapter = new MovieDetailsTrailerAdapter(this, movieDetailsTrailerAdapterOnClickHandler, new LinkedList<MovieTrailler>());
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerViewTrailers.getContext(),
                        mLinearLayoutManagerTrailers.getOrientation());
        mRecyclerViewTrailers.addItemDecoration(dividerItemDecoration);
        mRecyclerViewTrailers.setAdapter(mMovieDetailsTrailerAdapter);


        // adapter and viewHolder para os trailers
        mLinearLayoutManagerReviews = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewsReviews.setLayoutManager(mLinearLayoutManagerReviews);
        mRecyclerViewsReviews.setHasFixedSize(true);
        movieDetailsReviewsAdapterOnClickHandler = this;
        mMovieDetailsReviewsAdapter = new MovieDetailsReviewsAdapter(this, movieDetailsReviewsAdapterOnClickHandler, new LinkedList<MovieReview>());
        DividerItemDecoration dividerItemDecorationReviews =
                new DividerItemDecoration(mRecyclerViewTrailers.getContext(),
                        mLinearLayoutManagerTrailers.getOrientation());
        mRecyclerViewsReviews.addItemDecoration(dividerItemDecorationReviews);
        mRecyclerViewsReviews.setAdapter(mMovieDetailsReviewsAdapter);


    }

    private void actionBtnAddMovieFavoriteList(final ImageView mBtnAddFavorites){
        mBtnAddFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(movieIsPresentInFavoriteListOnLocalDB) {
                    removeMovieFavoriteList();
                    mBtnAddFavorites.setBackgroundResource(R.drawable.ic_best);
                }else{
                    addMovieToFavoriteList();
                    mBtnAddFavorites.setBackgroundResource(R.drawable.ic_star);
                }
            }
        });

    }

    private void defineIconBtnFavorite(int idMovie){
        if(movieIsPresentInFavoriteListOnLocalDB){

            mBtAddFavorites.setBackgroundResource(R.drawable.ic_star);
        }else{
            mBtAddFavorites.setBackgroundResource(R.drawable.ic_best);
        }

    }


    private void addMovieToFavoriteList(){
        Uri mNewUri;
        ContentValues mNewValues = new ContentValues();
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID, mIdMovie.getId());
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_DATE, MoviesDatesUtils.normalizeDate(MoviesDatesUtils.getNormalizedUtcDateForToday()));
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_DURATION, mDuration.getText().toString());
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_RATING, mRating.getText().toString());
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_TITLE, mTitle.getText().toString());
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_URL_IMAGE, mIdMovie.getUrlImage());
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_YEAR, mYear.getText().toString());
        mNewValues.put(MoviesContract.MoviesFavoritesEntry.COLUMN_DESCRIPTION, mDescription.getText().toString());

        mNewUri = getContentResolver().insert(MoviesContract.MoviesFavoritesEntry.CONTENT_URI, mNewValues);
    }

    private void removeMovieFavoriteList(){
        int count = MoviesAcessLocalDb.removeMovieFromFavoriteList(mIdMovie.getId(),this);

    }


    private void setInformationToViews(MovieDetail mMovie){
        mTitle.setText(mMovie.getTitle());
        mYear.setText(MovieUtils.getYearFromDate(mMovie.getYear()));
        mDuration.setText(MovieUtils.getDurationInMinutes(mMovie.getDuration()));
        mDescription.setText(mMovie.getDescription());
        mRating.setText(MovieUtils.convertRatingPercentage(mMovie.getRating()));
        Picasso.get().load(MovieUtils.getFullUrlImage(mMovie.getUtlImage())).into(mCover);
    }

    private void setInformationToViewsOFFLINEMODE(MovieDetail mMovie){
        mTitle.setText(mMovie.getTitle());
        mYear.setText(mMovie.getYear());
        mDuration.setText(mMovie.getDuration());
        mDescription.setText(mMovie.getDescription());
        mRating.setText(mMovie.getRating());
        Picasso.get().load(MovieUtils.getFullUrlImage(mMovie.getUtlImage())).into(mCover);
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
        isConnected(isConnected);
    }

    private void isConnected(boolean isConnected){
        if(isConnected){
            hiddeViewNoInternetConnection();
            //fetchingMovie.setMovieDetailsToView(mIdMovie.getId(),this);
            setMovieDetails(mIdMovie.getId(), this);
            fetchingMovie.setReviewsFromMovieToAdapter(mIdMovie.getId(), mMovieDetailsReviewsAdapter, this);
            fetchingMovie.setTrailersFromMovieToAdapter(mIdMovie.getId(),mMovieDetailsTrailerAdapter, this);
            showViewsWithInternet();
        }else{
            if(movieIsPresentInFavoriteListOnLocalDB){
                hiddeViewNoInternetConnection();
                MovieDetail movieDetail = MoviesAcessLocalDb.getMovieDetail(mIdMovie.getId(), this);
                setInformationToViewsOFFLINEMODE(movieDetail);
                showViewsWithNoInternet();
            }else {
                hideAllViews();
                showViewNoInternetConnection();
            }
        }
    }

    private void setMovieDetails(int idMovie, final Context context){
        TmdbApiService api = TmdbClientInstance.getRetrofitInstanceWithObserver().create(TmdbApiService.class);
        MovieRepository.getDetailsFromMovie(api, idMovie, new GetDetailsFromMovie() {
            @Override
            public void onSuccess(MovieDetail movieDetail) {
                setInformationToViews(movieDetail);

            }
            @Override
            public void onError() {
                Toasts.NoInternetConnectionToast(context);
            }
        });
    }

   private void hideAllViews(){
         mViewMovieInformation.setVisibility(View.INVISIBLE);
         mViewTrailers.setVisibility(View.INVISIBLE);
         mViewReviews.setVisibility(View.INVISIBLE);
   }

   private void showViewsWithInternet(){
        mViewMovieInformation.setVisibility(View.VISIBLE);
        mViewTrailers.setVisibility(View.VISIBLE);
        mViewReviews.setVisibility(View.VISIBLE);
    }

    private void showViewsWithNoInternet(){
        mViewMovieInformation.setVisibility(View.VISIBLE);
        mViewTrailers.setVisibility(View.INVISIBLE);
        mViewReviews.setVisibility(View.INVISIBLE);
    }

   private void showViewNoInternetConnection(){
        mViewNoInternet.setVisibility(View.VISIBLE);
   }

   private void hiddeViewNoInternetConnection(){
        mViewNoInternet.setVisibility(View.INVISIBLE);
   }

   private void createAndLoadToastNoInternetConnection(){
        //Toast toast = new Toasts().NoInternetConnection(this);
        //toast.show();
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
            case R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClickTrailer(int id) {
        MovieUtils.watchYoutubeVideo(this,mMovieDetailsTrailerAdapter.getTrailerFromList(id).getKey());
    }

    @Override
    public void onClickReviews(int id) {
        // handler action here
    }

}
