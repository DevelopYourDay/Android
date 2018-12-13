package com.example.jhordan.people_mvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.jhordan.people_mvvm.viewmodel.PeopleDetailViewModel;

public abstract class PeopleDetailActivityBinding extends ViewDataBinding {
  @NonNull
  public final FloatingActionButton fabStar;

  @NonNull
  public final ImageView imageGender;

  @NonNull
  public final ImageView imageHome;

  @NonNull
  public final ImageView imageMail;

  @NonNull
  public final ImageView imagePhone;

  @NonNull
  public final ImageView imageUser;

  @NonNull
  public final CardView peopleCard;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected PeopleDetailViewModel mPeopleDetailViewModel;

  protected PeopleDetailActivityBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FloatingActionButton fabStar, ImageView imageGender,
      ImageView imageHome, ImageView imageMail, ImageView imagePhone, ImageView imageUser,
      CardView peopleCard, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fabStar = fabStar;
    this.imageGender = imageGender;
    this.imageHome = imageHome;
    this.imageMail = imageMail;
    this.imagePhone = imagePhone;
    this.imageUser = imageUser;
    this.peopleCard = peopleCard;
    this.toolbar = toolbar;
  }

  public abstract void setPeopleDetailViewModel(@Nullable PeopleDetailViewModel peopleDetailViewModel);

  @Nullable
  public PeopleDetailViewModel getPeopleDetailViewModel() {
    return mPeopleDetailViewModel;
  }

  @NonNull
  public static PeopleDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PeopleDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PeopleDetailActivityBinding>inflate(inflater, com.example.jhordan.people_mvvm.R.layout.people_detail_activity, root, attachToRoot, component);
  }

  @NonNull
  public static PeopleDetailActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PeopleDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PeopleDetailActivityBinding>inflate(inflater, com.example.jhordan.people_mvvm.R.layout.people_detail_activity, null, false, component);
  }

  public static PeopleDetailActivityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PeopleDetailActivityBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PeopleDetailActivityBinding)bind(component, view, com.example.jhordan.people_mvvm.R.layout.people_detail_activity);
  }
}
