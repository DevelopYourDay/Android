package com.example.jhordan.people_mvvm.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class ItemPeopleBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView imagePeople;

  @NonNull
  public final RelativeLayout itemPeople;

  @NonNull
  public final TextView labelMail;

  @NonNull
  public final TextView labelName;

  @NonNull
  public final TextView labelPhone;

  @Bindable
  protected ItemPeopleViewModel mPeopleViewModel;

  protected ItemPeopleBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CircleImageView imagePeople, RelativeLayout itemPeople,
      TextView labelMail, TextView labelName, TextView labelPhone) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imagePeople = imagePeople;
    this.itemPeople = itemPeople;
    this.labelMail = labelMail;
    this.labelName = labelName;
    this.labelPhone = labelPhone;
  }

  public abstract void setPeopleViewModel(@Nullable ItemPeopleViewModel peopleViewModel);

  @Nullable
  public ItemPeopleViewModel getPeopleViewModel() {
    return mPeopleViewModel;
  }

  @NonNull
  public static ItemPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemPeopleBinding>inflate(inflater, com.example.jhordan.people_mvvm.R.layout.item_people, root, attachToRoot, component);
  }

  @NonNull
  public static ItemPeopleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemPeopleBinding>inflate(inflater, com.example.jhordan.people_mvvm.R.layout.item_people, null, false, component);
  }

  public static ItemPeopleBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemPeopleBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemPeopleBinding)bind(component, view, com.example.jhordan.people_mvvm.R.layout.item_people);
  }
}
