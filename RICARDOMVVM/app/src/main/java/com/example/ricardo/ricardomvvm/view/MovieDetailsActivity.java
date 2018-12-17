package com.example.ricardo.ricardomvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBinding;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsInformationBinding;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieReview;
import com.example.ricardo.ricardomvvm.view.adapter.MovieAdapter;
import com.example.ricardo.ricardomvvm.view.adapter.MovieDetailsReviewAdapter;
import com.example.ricardo.ricardomvvm.view.adapter.MovieDetailsViewPagerAdapter;
import com.example.ricardo.ricardomvvm.view.notifications.Toasts;
import com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel;

import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity {
    private static final String EXTRA_MOVIE = "EXTRA_MOVIE";
    private ActivityMovieDetailsBinding activityMovieDetailsBinding;
    private FragmentMovieDetailsInformationBinding fragmentMovieDetailsInformationBinding;
    public static  MovieDetailsViewModel movieDetailModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViewModel();
        initializeViewPage();
        initializeObservers();
        setSupportActionBar(activityMovieDetailsBinding.toolbarMovieDetails);
        displayHomeAsUpEnabled();
        initializeFetchData();
    }

    private void initializeViewModel(){
        movieDetailModel = ViewModelProviders.of(this).get(MovieDetailsViewModel.class);
        activityMovieDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        activityMovieDetailsBinding.setMovieDetailViewModel(movieDetailModel);
        activityMovieDetailsBinding.setLifecycleOwner(this);
    }

    private void initializeFetchData(){
        activityMovieDetailsBinding.getMovieDetailViewModel().setMovie(getExtrasFromIntent());
        activityMovieDetailsBinding.getMovieDetailViewModel().fetchDetailMovie();
        activityMovieDetailsBinding.getMovieDetailViewModel().fetchReviewsFromDetailMovie();
        activityMovieDetailsBinding.getMovieDetailViewModel().fetchTrailersFromDetailMovie();
    }


    private void setupListTrailers(RecyclerView listMovie) {
       // MovieDetailsReviewAdapter adapter = new MovieDetailsReviewAdapter();
       // listMovie.setAdapter(adapter);
        //listMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initializeObservers(){
        activityMovieDetailsBinding.getMovieDetailViewModel().getnotifications().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    Toast toast = Toasts.createToastNoInternetConnection(getApplicationContext());
                    toast.show();
                }
            }
        });

    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private Movie getExtrasFromIntent() {
        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);
        return movie;
    }

    public static Intent launchDetail(Context context, Movie people) {
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(EXTRA_MOVIE, people);
        return intent;
    }

    public void initializeViewPage(){
        MovieDetailsViewPagerAdapter adapter = new MovieDetailsViewPagerAdapter(this.getSupportFragmentManager(), activityMovieDetailsBinding.tabLayoutMovieDetails.getTabCount());
        activityMovieDetailsBinding.tabItemMovieDetailsViewpager.setAdapter(adapter);
        activityMovieDetailsBinding.tabItemMovieDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(activityMovieDetailsBinding.tabLayoutMovieDetails));
        activityMovieDetailsBinding.tabLayoutMovieDetails.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                activityMovieDetailsBinding.tabItemMovieDetailsViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
