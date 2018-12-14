package com.example.ricardo.ricardomvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBinding;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.example.ricardo.ricardomvvm.view.adapter.MovieDetailsViewPagerAdapter;
import com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel;

public class MovieDetailsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private static final String EXTRA_MOVIE = "EXTRA_MOVIE";

    private ActivityMovieDetailsBinding activityMovieDetailsBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Movie movie =  getExtrasFromIntent();
        initializeViewModel(movie);
        setSupportActionBar(activityMovieDetailsBinding.toolbarMovieDetails);
        displayHomeAsUpEnabled();
        tabLayout = (TabLayout) findViewById(R.id.tabLayout_movie_details);
        initializeViewPage();
    }



    private void initializeViewModel(Movie movie){

        MovieDetailsViewModel movieDetailModel = new MovieDetailsViewModel( movie,this);
        activityMovieDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        activityMovieDetailsBinding.setMovieDetailViewModel(movieDetailModel);
        activityMovieDetailsBinding.setLifecycleOwner(this);
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
        viewPager = (ViewPager) findViewById(R.id.tabItem_movie_details_viewpager);
        MovieDetailsViewPagerAdapter adapter = new MovieDetailsViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
