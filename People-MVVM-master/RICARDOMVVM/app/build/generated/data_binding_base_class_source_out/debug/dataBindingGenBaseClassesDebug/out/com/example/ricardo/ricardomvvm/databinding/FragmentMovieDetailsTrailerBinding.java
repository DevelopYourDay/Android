package com.example.ricardo.ricardomvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel;

public abstract class FragmentMovieDetailsTrailerBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout relativeLayoutFragmentMovieDetailsTrailer;

  @NonNull
  public final RecyclerView rvFragmentMovieDetailsTrailer;

  @Bindable
  protected MovieDetailsViewModel mMovieDetailsViewModel;

  protected FragmentMovieDetailsTrailerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout relativeLayoutFragmentMovieDetailsTrailer,
      RecyclerView rvFragmentMovieDetailsTrailer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.relativeLayoutFragmentMovieDetailsTrailer = relativeLayoutFragmentMovieDetailsTrailer;
    this.rvFragmentMovieDetailsTrailer = rvFragmentMovieDetailsTrailer;
  }

  public abstract void setMovieDetailsViewModel(@Nullable MovieDetailsViewModel movieDetailsViewModel);

  @Nullable
  public MovieDetailsViewModel getMovieDetailsViewModel() {
    return mMovieDetailsViewModel;
  }

  @NonNull
  public static FragmentMovieDetailsTrailerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMovieDetailsTrailerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMovieDetailsTrailerBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_trailer, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMovieDetailsTrailerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMovieDetailsTrailerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMovieDetailsTrailerBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_trailer, null, false, component);
  }

  public static FragmentMovieDetailsTrailerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMovieDetailsTrailerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMovieDetailsTrailerBinding)bind(component, view, com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_trailer);
  }
}
