package com.example.ricardo.ricardomvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel;

public abstract class FragmentMovieDetailsInformationBinding extends ViewDataBinding {
  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final Guideline guideline4;

  @NonNull
  public final Guideline guideline5;

  @NonNull
  public final Guideline guideline6;

  @NonNull
  public final ImageView imgDetailsMovieCover;

  @NonNull
  public final ImageView imgDetailsMovieMarkFavorite;

  @NonNull
  public final TextView tvMovieDescriptions;

  @NonNull
  public final TextView tvMovieDuration;

  @NonNull
  public final TextView tvMovieRating;

  @NonNull
  public final TextView tvMovieYear;

  @Bindable
  protected MovieDetailsViewModel mMovieDetailsViewModel;

  protected FragmentMovieDetailsInformationBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, Guideline guideline3, Guideline guideline4,
      Guideline guideline5, Guideline guideline6, ImageView imgDetailsMovieCover,
      ImageView imgDetailsMovieMarkFavorite, TextView tvMovieDescriptions, TextView tvMovieDuration,
      TextView tvMovieRating, TextView tvMovieYear) {
    super(_bindingComponent, _root, _localFieldCount);
    this.guideline3 = guideline3;
    this.guideline4 = guideline4;
    this.guideline5 = guideline5;
    this.guideline6 = guideline6;
    this.imgDetailsMovieCover = imgDetailsMovieCover;
    this.imgDetailsMovieMarkFavorite = imgDetailsMovieMarkFavorite;
    this.tvMovieDescriptions = tvMovieDescriptions;
    this.tvMovieDuration = tvMovieDuration;
    this.tvMovieRating = tvMovieRating;
    this.tvMovieYear = tvMovieYear;
  }

  public abstract void setMovieDetailsViewModel(@Nullable MovieDetailsViewModel movieDetailsViewModel);

  @Nullable
  public MovieDetailsViewModel getMovieDetailsViewModel() {
    return mMovieDetailsViewModel;
  }

  @NonNull
  public static FragmentMovieDetailsInformationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMovieDetailsInformationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMovieDetailsInformationBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_information, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMovieDetailsInformationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMovieDetailsInformationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMovieDetailsInformationBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_information, null, false, component);
  }

  public static FragmentMovieDetailsInformationBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMovieDetailsInformationBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMovieDetailsInformationBinding)bind(component, view, com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_information);
  }
}
