package com.example.ricardo.ricardomvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel;

public abstract class ActivityMovieBinding extends ViewDataBinding {
  @NonNull
  public final Guideline guideline;

  @NonNull
  public final RecyclerView rvListMovies;

  @NonNull
  public final SwipeRefreshLayout swipeMovieListRefresh;

  @NonNull
  public final ProgressBar widgetProgressBarListMovies;

  @Bindable
  protected MovieViewModel mMovieViewModel;

  protected ActivityMovieBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Guideline guideline, RecyclerView rvListMovies,
      SwipeRefreshLayout swipeMovieListRefresh, ProgressBar widgetProgressBarListMovies) {
    super(_bindingComponent, _root, _localFieldCount);
    this.guideline = guideline;
    this.rvListMovies = rvListMovies;
    this.swipeMovieListRefresh = swipeMovieListRefresh;
    this.widgetProgressBarListMovies = widgetProgressBarListMovies;
  }

  public abstract void setMovieViewModel(@Nullable MovieViewModel movieViewModel);

  @Nullable
  public MovieViewModel getMovieViewModel() {
    return mMovieViewModel;
  }

  @NonNull
  public static ActivityMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMovieBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.activity_movie, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMovieBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMovieBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.activity_movie, null, false, component);
  }

  public static ActivityMovieBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMovieBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMovieBinding)bind(component, view, com.example.ricardo.ricardomvvm.R.layout.activity_movie);
  }
}
