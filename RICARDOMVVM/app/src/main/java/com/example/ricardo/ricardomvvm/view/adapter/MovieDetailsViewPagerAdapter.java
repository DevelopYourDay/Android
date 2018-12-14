package com.example.ricardo.ricardomvvm.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ricardo.ricardomvvm.view.Tabs.MovieDetailsInformationFragment;
import com.example.ricardo.ricardomvvm.view.Tabs.MovieDetailsReviewsFragment;
import com.example.ricardo.ricardomvvm.view.Tabs.MovieDetailsTrailersFragment;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBinding;

public class MovieDetailsViewPagerAdapter extends FragmentStatePagerAdapter {
    private ActivityMovieDetailsBinding activityMovieDetailsBinding;
    int numberOfTabs;

    public MovieDetailsViewPagerAdapter(FragmentManager fragmentManager, int numberOfTabs) {
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // pass movie
                MovieDetailsInformationFragment  movieDetailsInformationFragment = MovieDetailsInformationFragment.newInstance();
                return movieDetailsInformationFragment;
            case 1:
                MovieDetailsReviewsFragment movieDetailsReviewsFragment =  MovieDetailsReviewsFragment.newInstance();
            return movieDetailsReviewsFragment;
            case 2:
                MovieDetailsTrailersFragment movieDetailsTrailersFragment =   MovieDetailsTrailersFragment.newInstance();
                return movieDetailsTrailersFragment;

            default:
                MovieDetailsInformationFragment  movieDetailsFragmentDefault =  MovieDetailsInformationFragment.newInstance();
                return movieDetailsFragmentDefault;
        }
    }

    @Override
    public int getCount() {
        return this.numberOfTabs;
    }
}
