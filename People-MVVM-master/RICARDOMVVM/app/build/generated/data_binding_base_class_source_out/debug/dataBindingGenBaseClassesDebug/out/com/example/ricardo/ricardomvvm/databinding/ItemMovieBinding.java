package com.example.ricardo.ricardomvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel;

public abstract class ItemMovieBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imgCoverMovie;

  @Bindable
  protected ItemMovieViewModel mMovieItemViewModel;

  protected ItemMovieBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imgCoverMovie) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imgCoverMovie = imgCoverMovie;
  }

  public abstract void setMovieItemViewModel(@Nullable ItemMovieViewModel movieItemViewModel);

  @Nullable
  public ItemMovieViewModel getMovieItemViewModel() {
    return mMovieItemViewModel;
  }

  @NonNull
  public static ItemMovieBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMovieBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMovieBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.item_movie, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMovieBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMovieBinding>inflate(inflater, com.example.ricardo.ricardomvvm.R.layout.item_movie, null, false, component);
  }

  public static ItemMovieBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMovieBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMovieBinding)bind(component, view, com.example.ricardo.ricardomvvm.R.layout.item_movie);
  }
}
