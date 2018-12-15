package com.example.ricardo.ricardomvvm.view.Tabs;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBinding;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsInformationBinding;
import com.example.ricardo.ricardomvvm.view.MovieDetailsActivity;
import com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel;

public class MovieDetailsInformationFragment extends Fragment {

    public static FragmentMovieDetailsInformationBinding fragmentMovieDetailsInformationBinding;
    private MovieDetail movieDetail;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        fragmentMovieDetailsInformationBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_details_information, container, false);
        fragmentMovieDetailsInformationBinding.setMovieDetailInformationViewModel(MovieDetailsActivity.movieDetailModel);
        fragmentMovieDetailsInformationBinding.setLifecycleOwner(this);
        return fragmentMovieDetailsInformationBinding.getRoot();
    }


    public static MovieDetailsInformationFragment newInstance() {
        Bundle args = new Bundle();
        MovieDetailsInformationFragment fragment = new MovieDetailsInformationFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
