package com.example.ricardo.ricardomvvm.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ricardo.ricardomvvm.Utils.ConnectivityReceiver;
import com.example.ricardo.ricardomvvm.Utils.MovieApplication;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieBinding;
import com.example.ricardo.ricardomvvm.databinding.ItemMovieBinding;
import com.example.ricardo.ricardomvvm.databinding.ItemMovieBindingImpl;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.view.adapter.MovieAdapter;
import com.example.ricardo.ricardomvvm.view.notifications.Toasts;
import com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MovieActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {
    private ActivityMovieBinding movieActivityBinding;
    private ItemMovieBinding itemMovieBinding;
    private MovieViewModel movieViewModel;
    private static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";


    public static final String PREFS_NAME_FILE = "MyPrefsFile";
    public static final String MOVIES_POPULAR = "MOVIES_POPULAR";
    public static final String MOVIES_TOP_RATED = "MOVIES_TOP_RATED";
    public static final String MOVIES_FAVORITES = "MOVIES_FAVORITES";
    public static final String PREFS_MOVIE_TYPE_KEY = "MOVIE_";
    public static final String PREFS_SORT_MOVIE_DEFAULT = MOVIES_POPULAR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_movie);

    }


    private void initialize(boolean isConnected) {
        if (isConnected) {
            // setContentView(R.layout.movie_main);
            initPreferences();
            initDataBinding();
            setupListMovieView(movieActivityBinding.rvListMovies);
            observable();
        } else {
            setContentView(R.layout.partial_no_internet_connection);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        MovieApplication.getInstance().setConnectivityListener(this);
    }


    private String initPreferences() {
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
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie);
        movieActivityBinding.setMovieViewModel(movieViewModel);
        movieActivityBinding.getMovieViewModel().setPredefinedTypeSearchMovie(getPredefinedTypeSearchMovie());
        movieActivityBinding.getMovieViewModel().initializeAttributes();
        movieActivityBinding.getMovieViewModel().initializeViews();
        movieActivityBinding.getMovieViewModel().fetchData();
    }

    private void setupListMovieView(RecyclerView listMovie) {
        MovieAdapter adapter = new MovieAdapter();
        listMovie.setAdapter(adapter);
        listMovie.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //movieViewModel.reset();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
                        setNewPreference(MOVIES_POPULAR);
                        setupListMovieView(movieActivityBinding.rvListMovies);
                        movieActivityBinding.getMovieViewModel().setPredefinedTypeSearchMovie(MOVIES_POPULAR);
                        movieActivityBinding.getMovieViewModel().onChangedTypeSearchMovie();
                        return true;
                    case R.id.top_rated:
                        setNewPreference(MOVIES_TOP_RATED);
                        setupListMovieView(movieActivityBinding.rvListMovies);
                        movieActivityBinding.getMovieViewModel().setPredefinedTypeSearchMovie(MOVIES_TOP_RATED);
                        movieActivityBinding.getMovieViewModel().onChangedTypeSearchMovie();
                        return true;
                    case R.id.favorites:
                        //HANDLER WHERE
                        return true;
                    default:
                        return false;
                }
            }
        });
        sortMenu.inflate(R.menu.menu_movie_sorte);
        sortMenu.show();
    }


    public void observable() {
        movieViewModel.getMovieList().observe(this, new android.arch.lifecycle.Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                MovieAdapter movieAdapter = (MovieAdapter) movieActivityBinding.rvListMovies.getAdapter();
                movieAdapter.update(movies);
            }
        });

        movieViewModel.getNoInternetConnection().observe(this, new android.arch.lifecycle.Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    Toast toast = Toasts.createToastNoInternetConnection(getApplicationContext());
                    toast.show();
                }
            }
    });


    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        initialize(isConnected);
    }

    public String getPredefinedTypeSearchMovie() {
        SharedPreferences settings = this.getSharedPreferences(PREFS_NAME_FILE, 0);
        String moviePref = settings.getString(PREFS_MOVIE_TYPE_KEY, PREFS_SORT_MOVIE_DEFAULT);
        return moviePref;
    }


}
