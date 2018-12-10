package com.example.e5813.movieapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.data.MoviesContract;
import com.example.e5813.movieapp.models.movies.Movie;
import com.example.e5813.movieapp.networks.InternetCheckConnection.ConnectivityReceiver;
import com.example.e5813.movieapp.networks.InternetCheckConnection.MyApplication;
import com.example.e5813.movieapp.networks.tmdb.movies.FetchingMovie;
import com.example.e5813.movieapp.views.adapter.MovieAdapter;

import java.util.LinkedList;
import java.util.List;

public class MovieList extends AppCompatActivity implements MovieAdapter.MoviesAdapterOnClickHandler, ConnectivityReceiver.ConnectivityReceiverListener {

    public static final String PREFS_NAME_FILE = "MyPrefsFile";
    private static final String MOVIES_POPULAR = "MOVIES_POPULAR";
    private static final String MOVIES_TOP_RATED = "MOVIES_TOP_RATED";
    private static final String MOVIES_FAVORITES = "MOVIES_FAVORITES";
    private static final String PREFS_MOVIE_TYPE_SEARCH_KEY = "MOVIE_";
    public static final String PREFS_SORT_MOVIE_DEFAULT = MOVIES_POPULAR;

    private static final int DEFAULT_VALUE_FROM_PAGE_REQUEST = 1;
    private static final boolean DEFAULT_VALUE_FROM_FETECHING_MOVIES_REQUEST = false;

    private static final String SAVED_RECYCLER_VIEW_STATUS_ID = "SAVED_RECYCLER_VIEW_STATUS_ID";
    private static final String SAVED_RECYCLER_VIEW_POSITION = "SAVED_RECYCLER_VIEW_ADAPTER_ID";

    private Parcelable mlistState;
    public static final String PARCEL_MOVIE_ID = "PARCEL_MOVIE_ID";



    private RecyclerView mRecyclerView;
    private ProgressBar mLoadingIndicator;
    private View mNoInternetConnection;
    private MovieAdapter mMovieAdapter;
    private GridLayoutManager layoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Cursor mCursor;

    private FetchingMovie fetchingMovies;

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

    private MovieAdapter.MoviesAdapterOnClickHandler moviesAdapterOnClickHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_movies);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.widget_progress_bar_list_movies);
        mNoInternetConnection = (View) findViewById(R.id.layout_no_internet_connection);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_movie_list_refresh);

        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        moviesAdapterOnClickHandler = this;
        mMovieAdapter = new MovieAdapter(this, moviesAdapterOnClickHandler,  new LinkedList<Movie>());
        mRecyclerView.setAdapter(mMovieAdapter);

        fetchingMovies  = new FetchingMovie(DEFAULT_VALUE_FROM_FETECHING_MOVIES_REQUEST, DEFAULT_VALUE_FROM_PAGE_REQUEST);

        setupOnScrollListener();
        setupSwipeRefreshLayout();
        isConnected(ConnectivityReceiver.isConnected());
    }


    private void setupSwipeRefreshLayout(){
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isConnected(ConnectivityReceiver.isConnected());
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        isConnected(ConnectivityReceiver.isConnected());
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        isConnected(ConnectivityReceiver.isConnected());
    }

    private void isConnected(boolean isConnected) {
        if (isConnected) {
            hideViewNoInternetConnection();
            showLoading();
            addMoviesToAdapter(getPredefinedTypeSearchMovie());
            showMovieDataView();
        } else {
            if(getPredefinedTypeSearchMovie().equals(MOVIES_FAVORITES)){
                addMoviesToAdapter(getPredefinedTypeSearchMovie());
            }else{
                hideProgressBarAndRv();
                showViewNoInternetConnection();
            }
        }
    }


    private void addMoviesToAdapter(String type) {
        switch (type) {
            case MOVIES_POPULAR:
                fetchingMovies.getPopularMovies(mMovieAdapter, this);
                break;
            case MOVIES_TOP_RATED:
                fetchingMovies.getTopRatedMovies(mMovieAdapter, this);
                break;
            case MOVIES_FAVORITES:
                getMoviesFavorites();
                break;
            default:
                break;
        }
    }

    private void showViewNoInternetConnection() {
        mNoInternetConnection.setVisibility(View.VISIBLE);
    }

    private void hideProgressBarAndRv() {
        mRecyclerView.setVisibility(View.INVISIBLE);
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }

    private void hideViewNoInternetConnection() {
        mNoInternetConnection.setVisibility(View.INVISIBLE);
    }

    private void showLoading() {
        mRecyclerView.setVisibility(View.INVISIBLE);
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    private void showMovieDataView() {
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(int id) {
        Intent movieDetailIntent = new Intent(MovieList.this, MovieDetails.class);
        Movie movie = mMovieAdapter.getMovieFromList(id);
        movieDetailIntent.putExtra(PARCEL_MOVIE_ID, movie);
        startActivity(movieDetailIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort:
                showSortMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showSortMenu() {
        PopupMenu sortMenu = new PopupMenu(this, findViewById(R.id.sort));
        sortMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.popular:
                        fetchingMovies.setCurrentPage(DEFAULT_VALUE_FROM_PAGE_REQUEST);
                        setPredefinedTypeSearchMovie(MOVIES_POPULAR);
                        mMovieAdapter.cleanMovies();
                        isConnected(ConnectivityReceiver.isConnected());
                        return true;
                    case R.id.top_rated:
                        fetchingMovies.setCurrentPage(DEFAULT_VALUE_FROM_PAGE_REQUEST);
                        setPredefinedTypeSearchMovie(MOVIES_TOP_RATED);
                        mMovieAdapter.cleanMovies();
                        isConnected(ConnectivityReceiver.isConnected());
                        return true;
                    case R.id.favorites:
                        setPredefinedTypeSearchMovie(MOVIES_FAVORITES);
                        mMovieAdapter.cleanMovies();
                        getMoviesFavorites();
                        return true;
                    default:
                        return false;
                }
            }
        });
        sortMenu.inflate(R.menu.menu_movie_sorte);
        sortMenu.show();
    }

    private void getMoviesFavorites() {
        String[] mProjection = {
                MoviesContract.MoviesFavoritesEntry.COLUMN_URL_IMAGE,
                MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID
        };

        mCursor = getContentResolver().query(MoviesContract.MoviesFavoritesEntry.CONTENT_URI, mProjection,
                null, null, null);

        List<Movie> listMovie = new LinkedList<>();
        if (null == mCursor) {
            // inflate information no favorites movie add;
        } else if (mCursor.getCount() >= 1) {
            int url = mCursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_URL_IMAGE);
            int movieID = mCursor.getColumnIndex(MoviesContract.MoviesFavoritesEntry.COLUMN_MOVIE_ID);
            while (mCursor.moveToNext()) {
                Movie movie = new Movie(mCursor.getInt(movieID), mCursor.getString(url));
                listMovie.add(movie);
            }
        } else {
            // inflate information no favorites movie add;
        }
        refreshAdapterFavorites(listMovie);
    }

    private void setPredefinedTypeSearchMovie(String preference) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_MOVIE_TYPE_SEARCH_KEY, preference);
        editor.commit();
    }

    private String getPredefinedTypeSearchMovie() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME_FILE, 0);
        String moviePref = settings.getString(PREFS_MOVIE_TYPE_SEARCH_KEY, PREFS_SORT_MOVIE_DEFAULT);
        return moviePref;
    }

    private void refreshAdapterFavorites(List<Movie> movies) {
        mMovieAdapter.cleanMovies();
        mMovieAdapter.appendMovies(movies);
    }


    private void setupOnScrollListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                    int totalItemCount = layoutManager.getItemCount();
                    int visibleItemCount = layoutManager.getChildCount();
                    int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

                    if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                        if (!fetchingMovies.getFetchingMovies()) {
                            fetchingMovies.setCurrentPage((fetchingMovies.getCurrentPage()+1));
                            isConnected(ConnectivityReceiver.isConnected());
                        }
                    }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //mlistState = layoutManager.onSaveInstanceState();
        //outState.putParcelable(SAVED_RECYCLER_VIEW_STATUS_ID, layoutManager.onSaveInstanceState());
        int i = layoutManager.findFirstVisibleItemPosition();
        outState.putInt(SAVED_RECYCLER_VIEW_POSITION, i);
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        // Retrieve list state and list/item positions
        if (state != null) {
            //  mlistState = state.getParcelable(SAVED_RECYCLER_VIEW_STATUS_ID);
            //layoutManager.onRestoreInstanceState(mlistState);
            mRecyclerView.smoothScrollToPosition(state.getInt(SAVED_RECYCLER_VIEW_POSITION));
            //mRecyclerView.setLayoutManager(layoutManager);
        }

    }


}
