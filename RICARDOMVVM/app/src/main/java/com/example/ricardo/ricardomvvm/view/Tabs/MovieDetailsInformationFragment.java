package com.example.ricardo.ricardomvvm.view.Tabs;

import android.arch.lifecycle.Observer;
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
import com.example.ricardo.ricardomvvm.viewmodel.MovieDetailInformationViewModel;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBinding;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsInformationBinding;

public class MovieDetailsInformationFragment extends Fragment {

    public static ActivityMovieDetailsBinding activityMovieDetailsBinding;
    public static FragmentMovieDetailsInformationBinding fragmentMovieDetailsInformationBinding;
    private MovieDetail movieDetail;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        initializeViewModel();
        return inflater.inflate(R.layout.fragment_movie_details_information, container, false);
    }

    public static MovieDetailsInformationFragment newInstance() {
        Bundle args = new Bundle();
        MovieDetailsInformationFragment fragment = new MovieDetailsInformationFragment();
        fragment.setArguments(args);
        return fragment;

    }

    public void initializeViewModel(){

        MovieDetailInformationViewModel movieDetailInformationViewModel = ViewModelProviders.of(getActivity()).get(MovieDetailInformationViewModel.class);
        activityMovieDetailsBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_movie_details_information);
        //fragmentMovieDetailsInformationBinding.setMovieDetailInformationViewModel(movieDetailInformationViewModel);
        //fragmentMovieDetailsInformationBinding.getMovieDetailInformationViewModel().setCurrentMovieDetails(activityMovieDetailsBinding.getMovieDetailViewModel().getMovieDetail().getValue());
        //fragmentMovieDetailsInformationBinding.setLifecycleOwner(this);

      /**  activityMovieDetailsBinding.getMovieDetailViewModel().getMovieDetail().observe(this, new Observer<MovieDetail>() {
            @Override
            public void onChanged(@Nullable MovieDetail movieDetail) {
                fragmentMovieDetailsInformationBinding.getMovieDetailInformationViewModel().setCurrentMovieDetails(movieDetail);
            }
        });**/

    }



}
