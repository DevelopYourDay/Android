package com.example.ricardo.ricardomvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel;

public abstract class ActivityMovieDetailsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout mainLayout;

  @NonNull
  public final TabItem tabItemMovieDetailsInformation;

  @NonNull
  public final TabItem tabItemMovieDetailsReviews;

  @NonNull
  public final TabItem tabItemMovieDetailsTrailers;

  @NonNull
  public final ViewPager tabItemMovieDetailsViewpager;

  @NonNull
  public final TabLayout tabLayoutMovieDetails;

  @NonNull
  public final Toolbar toolbarMovieDetails;

  @NonNull
  public final TextView tvMovieTitle;

  @Bindable
  protected MovieDetailsViewModel mMovieDetailViewModel;

  protected ActivityMovieDetailsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout mainLayout, TabItem tabItemMovieDetailsInformation,
      TabItem tabItemMovieDetailsReviews, TabItem tabItemMovieDetailsTrailers,
      ViewPager tabItemMovieDetailsViewpager, TabLayout tabLayoutMovieDetails,
      Toolbar toolbarMovieDetails, TextView tvMovieTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.mainLayout = mainLayout;
    this.tabItemMovieDetailsInformation = tabItemMovieDetailsInformation;
    this.tabItemMovieDetailsReviews = tabItemMovieDetailsReviews;
    this.tabItemMovieDetailsTrailers = tabItemMovieDetailsTrailers;
    this.tabItemMovieDetailsViewpager = tabItemMovieDetailsViewpager;
    this.tabLayoutMovieDetails = tabLayoutMovieDetails;
    this.toolbarMovieDetails = toolbarMovieDetails;
    this.tvMovieTitle = tvMovieTitle;
  }

  public abstract void setMovieDetailViewModel(@Nullable MovieDetailsViewModel movieDetailViewModel);

  @Nullable
  public MovieDetailsViewModel getMovieDetailViewModel() {
    return mMovieDetailViewModel;
  }

  @NonNull
  public static ActivityMovieDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMovieDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMovieDetailsBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.activity_movie_details, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMovieDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMovieDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMovieDetailsBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.activity_movie_details, null, false, component);
  }

  public static ActivityMovieDetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMovieDetailsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMovieDetailsBinding)bind(component, view, com.example.ricardo.ricardomvvm.R.layout.activity_movie_details);
  }
}
