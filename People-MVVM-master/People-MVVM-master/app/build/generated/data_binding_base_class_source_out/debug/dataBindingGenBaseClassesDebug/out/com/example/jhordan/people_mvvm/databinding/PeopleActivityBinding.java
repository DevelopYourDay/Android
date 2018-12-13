package com.example.jhordan.people_mvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.jhordan.people_mvvm.viewmodel.PeopleViewModel;

public abstract class PeopleActivityBinding extends ViewDataBinding {
  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final TextView labelStatus;

  @NonNull
  public final RecyclerView listPeople;

  @NonNull
  public final ProgressBar progressPeople;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected PeopleViewModel mMainViewModel;

  protected PeopleActivityBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FloatingActionButton fab, TextView labelStatus, RecyclerView listPeople,
      ProgressBar progressPeople, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fab = fab;
    this.labelStatus = labelStatus;
    this.listPeople = listPeople;
    this.progressPeople = progressPeople;
    this.toolbar = toolbar;
  }

  public abstract void setMainViewModel(@Nullable PeopleViewModel mainViewModel);

  @Nullable
  public PeopleViewModel getMainViewModel() {
    return mMainViewModel;
  }

  @NonNull
  public static PeopleActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PeopleActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PeopleActivityBinding>inflate(inflater, com.example.jhordan.people_mvvm.R.layout.people_activity, root, attachToRoot, component);
  }

  @NonNull
  public static PeopleActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PeopleActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PeopleActivityBinding>inflate(inflater, com.example.jhordan.people_mvvm.R.layout.people_activity, null, false, component);
  }

  public static PeopleActivityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PeopleActivityBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PeopleActivityBinding)bind(component, view, com.example.jhordan.people_mvvm.R.layout.people_activity);
  }
}
