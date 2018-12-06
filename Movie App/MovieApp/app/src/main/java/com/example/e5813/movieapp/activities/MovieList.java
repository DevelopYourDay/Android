package com.example.e5813.movieapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMovieTopRated;
import com.example.e5813.movieapp.networks.Interfaces.OnGetMoviesCallback;
import com.example.e5813.movieapp.networks.Interfaces.TmdbApiService;
import com.example.e5813.movieapp.networks.InternetCheckConnection.ConnectivityReceiver;
import com.example.e5813.movieapp.networks.InternetCheckConnection.MyApplication;
import com.example.e5813.movieapp.networks.MoviesRepository;
import com.example.e5813.movieapp.networks.TmdbClientInstance;
import com.example.e5813.movieapp.views.adapter.MovieAdapter;
import com.example.e5813.movieapp.views.notifications.Toasts;

import java.util.LinkedList;
import java.util.List;

public class MovieList extends AppCompatActivity implements MovieAdapter.MoviesAdapterOnClickHandler,ConnectivityReceiver.ConnectivityReceiverListener {

    public static final String PREFS_NAME_FILE = "MyPrefsFile";
    // default MOVIES_POPULAR
    public static final String PREFS_SORT_MOVIE = "MOVIES_POPULAR";


    public static final String PARCEL_MOVIE_ID = "PARCEL_MOVIE_ID";

    private static final String MOVIES_POPULAR = "MOVIES_POPULAR";
    private static final String MOVIES_TOP_RATED = "MOVIES_TOP_RATED";

    private RecyclerView mRecyclerView;
    private ProgressBar mLoadingIndicator;
    private  View mNoInternetConnection;
    private MovieAdapter mMovieAdapter;
    //private FetchMovies mfetchMovies;
    private GridLayoutManager layoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    /**
     *  flag that we will use to determine if we are currently fetching the next page.
     *  Without this flag, if the we scrolled 50% above it will fetch the same page multiple times and causes duplication.
     *  Try commenting out this flag and you will notice that when you scroll, you will see the same movies of next page again and again.
     */
    private boolean isFetchingMovies;
    /**
     * Initialized to page 1.
     * Every time we scrolled half of the list we increment it by one which is the next page.
     */
    private int currentPage = 1;

    private MovieAdapter.MoviesAdapterOnClickHandler moviesAdapterOnClickHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_movies);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.widget_progress_bar_list_movies);
        mNoInternetConnection = (View) findViewById(R.id.layout_no_internet_connection);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_movie_list_refresh);
        layoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        moviesAdapterOnClickHandler =  this;
        //mfetchMovies = new FetchMovies(this);
        List<Movie> listMovie = new LinkedList<>();
        mMovieAdapter = new MovieAdapter(this , moviesAdapterOnClickHandler, listMovie);
        mRecyclerView.setAdapter(mMovieAdapter);
        setupOnScrollListener();

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
        isConnected(ConnectivityReceiver.isConnected());
        super.onStart();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        isConnected(ConnectivityReceiver.isConnected());
    }

    private void isConnected(boolean isConnected){
        if(isConnected){
            hideViewNoInternetConnection();
            showLoading();
            addMoviesToAdapter(loadSortMovieDefinidoFromPreferences());
            showMovieDataView();
        }else{
            hideProgressBarAndRv();
            showViewNoInternetConnection();
        }
    }



    private void addMoviesToAdapter(String type){
           switch(type) {
               case MOVIES_POPULAR:
                   getMovieListByPopular();
                   break;
               case MOVIES_TOP_RATED:
                   getMovieListByTopRated();
                   break;

                   default:
                       break;
           }
    }

    private void showViewNoInternetConnection(){
        mNoInternetConnection.setVisibility(View.VISIBLE);
    }

    private void hideProgressBarAndRv(){
        mRecyclerView.setVisibility(View.INVISIBLE);
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }

    private void hideViewNoInternetConnection(){
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
        Intent movieDetailIntent = new Intent(MovieList.this,MovieDetails.class);
        Movie movie = mMovieAdapter.getMovieFromList(id);
        movieDetailIntent.putExtra(PARCEL_MOVIE_ID, movie.getId());
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
                        changesortMoviePReference(MOVIES_POPULAR);
                        mMovieAdapter.cleanMovies();
                        isConnected(ConnectivityReceiver.isConnected());
                        currentPage =1;
                        return true;
                    case R.id.top_rated:
                        changesortMoviePReference(MOVIES_TOP_RATED);
                        mMovieAdapter.cleanMovies();
                        isConnected(ConnectivityReceiver.isConnected());
                        currentPage = 1;
                        return true;
                    default:
                        return false;
                }
            }
        });
        sortMenu.inflate(R.menu.menu_movie_sorte);
        sortMenu.show();
    }

    private void changesortMoviePReference(String preference){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_SORT_MOVIE, preference);
        editor.commit();
    }

    private String loadSortMovieDefinidoFromPreferences(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME_FILE, 0);
        String moviePref = settings.getString(PREFS_SORT_MOVIE, PREFS_SORT_MOVIE);
        return moviePref;
    }



    private void refreshAdapter(List<Movie> movies){
        mMovieAdapter.appendMovies(movies);
    }

    private void createAndLoadToastNoInternetConnection(){
        Toast toast = new Toasts().NoInternetConnection(this);
        toast.show();
    }

    /**
     * Fetech Movies sorted by Popular
     */
    public  void  getMovieListByPopular(){
        isFetchingMovies = true;
        final TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MoviesRepository.getMovies(api,currentPage,new OnGetMoviesCallback() {
            @Override
            public void onSuccess(int page,List<Movie> movies) {
                refreshAdapter(movies);
                currentPage = page;
                isFetchingMovies = false;
            }

            @Override
            public void onError() {
                createAndLoadToastNoInternetConnection();
            }
        });
    }

    /**
     * Fetech moveis sorted by Top Rated
     */
    public void  getMovieListByTopRated(){
        isFetchingMovies = true;
        TmdbApiService api = TmdbClientInstance.getRetrofitInstance().create(TmdbApiService.class);
        MoviesRepository.getMoviesTopRated(api,currentPage, new OnGetMovieTopRated() {
            @Override
            public void onSuccess(int page,List<Movie> movies) {
                refreshAdapter(movies);
                currentPage = page;
                isFetchingMovies = false;
            }
            @Override
            public void onError() {
                createAndLoadToastNoInternetConnection();
            }
        });
    }

    private void setupOnScrollListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int totalItemCount = layoutManager.getItemCount();
                int visibleItemCount = layoutManager.getChildCount();
                int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    if (!isFetchingMovies) {
                        currentPage++;
                        isConnected(ConnectivityReceiver.isConnected());
                    }
                }
            }
        });
    }



}
