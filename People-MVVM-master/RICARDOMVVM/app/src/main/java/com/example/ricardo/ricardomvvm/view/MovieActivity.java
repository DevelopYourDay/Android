package com.example.ricardo.ricardomvvm.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ricardo.ricardomvvm.ConnectivityReceiver;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.data.remote.MoviesFactory;
import com.example.ricardo.ricardomvvm.databinding.MovieMainBinding;
import com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel;

import java.util.Observable;
import java.util.Observer;

public class MovieActivity extends AppCompatActivity implements Observer, ConnectivityReceiver.ConnectivityReceiverListener {
    private MovieMainBinding movieActivityBinding;
    private MovieViewModel movieViewModel;


    public static final String PREFS_NAME_FILE = "MyPrefsFile";
    private static final String MOVIES_POPULAR = "MOVIES_POPULAR";
    private static final String MOVIES_TOP_RATED = "MOVIES_TOP_RATED";
    private static final String MOVIES_FAVORITES = "MOVIES_FAVORITES";
    private static final String PREFS_MOVIE_TYPE_KEY = "MOVIE_";
    public static final String PREFS_SORT_MOVIE_DEFAULT = MOVIES_POPULAR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_main);
        initPreferences();
        initDataBinding();
        setupListMovieView(movieActivityBinding.rvListMovies);
        setupObserver(movieViewModel);
    }

    private String initPreferences(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME_FILE, 0);
        String moviePreferences = settings.getString(PREFS_MOVIE_TYPE_KEY, PREFS_SORT_MOVIE_DEFAULT);
        return moviePreferences;
    }

    private void setNewPreference(String preference) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_MOVIE_TYPE_KEY, preference);
        editor.commit();
    }

    private void initDataBinding() {
        movieActivityBinding = DataBindingUtil.setContentView(this, R.layout.movie_main);
        movieViewModel = new MovieViewModel(this);
        movieActivityBinding.setMovieViewModel(movieViewModel);
    }

    private void setupListMovieView(RecyclerView listMovie) {
        MovieAdapter adapter = new MovieAdapter();
        listMovie.setAdapter(adapter);
        listMovie.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        movieViewModel.reset();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sort) {
            showSortMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showSortMenu() {
        PopupMenu sortMenu = new PopupMenu(this, findViewById(R.id.sort));
        sortMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.popular:
                        startActivityActionView();
                        return true;
                    case R.id.top_rated:

                        return true;
                    case R.id.favorites:

                        return true;
                    default:
                        return false;
                }
            }
        });
        sortMenu.inflate(R.menu.menu_movie_sorte);
        sortMenu.show();
    }

    private void startActivityActionView() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MoviesFactory.TMDB_BASE_URL)));
    }

    @Override public void update(Observable observable, Object data) {
        if (observable instanceof MovieViewModel) {
            MovieAdapter movieAdapter = (MovieAdapter) movieActivityBinding.rvListMovies.getAdapter();
            MovieViewModel movieViewModel = (MovieViewModel) observable;
            movieAdapter.appendMovies(movieViewModel.getMovieList());
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if(isConnected){
            initPreferences();
            initDataBinding();
            setupListMovieView(movieActivityBinding.rvListMovies);
            setupObserver(movieViewModel);
        }else{
                // handler
        }
    }
}