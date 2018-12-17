package com.example.ricardo.ricardomvvm.view.Tabs;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsReviewBinding;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBinding;

import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.model.MovieReview;
import com.example.ricardo.ricardomvvm.view.MovieDetailsActivity;
import com.example.ricardo.ricardomvvm.view.adapter.MovieAdapter;
import com.example.ricardo.ricardomvvm.view.adapter.MovieDetailsReviewAdapter;

import java.util.List;

public class MovieDetailsReviewsFragment extends Fragment {
    FragmentMovieDetailsReviewBinding fragmentMovieDetailsReviewBinding;
    ActivityMovieDetailsBinding activityMovieDetailsBinding;
    LayoutInflater inflater;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        this.inflater = inflater;
        fragmentMovieDetailsReviewBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_details_review, container, false);
        fragmentMovieDetailsReviewBinding.setViewModel(MovieDetailsActivity.movieDetailModel);
        obsetvers();
        MovieDetailsActivity.movieDetailModel.fetchReviewsFromDetailMovie();
        fragmentMovieDetailsReviewBinding.setLifecycleOwner(this);
        return fragmentMovieDetailsReviewBinding.getRoot();
    }

    public static MovieDetailsReviewsFragment newInstance() {
        Bundle args = new Bundle();
        MovieDetailsReviewsFragment fragment = new MovieDetailsReviewsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private void setupListReview(RecyclerView listMovie, List<MovieReview> movieReviews) {
        MovieDetailsReviewAdapter adapter = new MovieDetailsReviewAdapter();
        listMovie.setAdapter(adapter);
        listMovie.setLayoutManager(new LinearLayoutManager(inflater.getContext(), LinearLayoutManager.VERTICAL, false));
        adapter.appendReview(movieReviews);
    }

    private void obsetvers(){
        MovieDetailsActivity.movieDetailModel.getListMovieReview().observe(this, new Observer<List<MovieReview>>() {
            @Override
            public void onChanged(@Nullable List<MovieReview> movieReviews) {
                setupListReview(fragmentMovieDetailsReviewBinding.rvFragmentMovieDetailsReview, movieReviews);
            }
        });
    }



}
