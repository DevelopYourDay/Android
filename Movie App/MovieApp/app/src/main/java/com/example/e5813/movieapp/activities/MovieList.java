package com.example.e5813.movieapp.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
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
import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.networks.InternetCheckConnection.ConnectivityReceiver;
import com.example.e5813.movieapp.networks.FetchMovies;
import com.example.e5813.movieapp.networks.InternetCheckConnection.MyApplication;
import com.example.e5813.movieapp.views.adapter.MovieAdapter;

import java.util.List;

public class MovieList extends AppCompatActivity implements MovieAdapter.MoviesAdapterOnClickHandler,ConnectivityReceiver.ConnectivityReceiverListener {

    public static final String PARCEL_MOVIE_ID = "PARCEL_MOVIE_ID";
    private RecyclerView mRecyclerView;
    private ProgressBar mLoadingIndicator;
    private  View mNoInternetConnection;
    private MovieAdapter mMovieAdapter;
    private FetchMovies mfetchMovies;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MovieAdapter.MoviesAdapterOnClickHandler moviesAdapterOnClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_movies);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.widget_progress_bar_list_movies);
        mNoInternetConnection = (View) findViewById(R.id.layout_no_internet_connection);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_movie_list_refresh);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        moviesAdapterOnClickHandler =  this;
        mfetchMovies = new FetchMovies(this);

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
            addMoviesToAdapter();
            showMovieDataView();
        }else{
            hideProgressBarAndRv();
            showViewNoInternetConnection();
        }
    }

    private void addMoviesToAdapter(){
        mMovieAdapter = new MovieAdapter(this, moviesAdapterOnClickHandler, mfetchMovies.getMovieListByPopular());
        mRecyclerView.setAdapter(mMovieAdapter);
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
                        showLoading();
                        mfetchMovies.getMovieListByPopular();
                        showMovieDataView();
                        return true;
                    case R.id.top_rated:
                        showLoading();
                        mfetchMovies.getMovieListByTopRated();
                        showMovieDataView();
                        return true;
                    default:
                        return false;
                }
            }
        });
        sortMenu.inflate(R.menu.menu_movie_sorte);
        sortMenu.show();
    }


}
