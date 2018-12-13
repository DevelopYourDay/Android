package com.example.ricardo.ricardomvvm.view.Tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricardo.ricardomvvm.R;

public class MovieDetailsReviewsFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details_review, container, false);
    }

    public static MovieDetailsReviewsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MovieDetailsReviewsFragment fragment = new MovieDetailsReviewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
