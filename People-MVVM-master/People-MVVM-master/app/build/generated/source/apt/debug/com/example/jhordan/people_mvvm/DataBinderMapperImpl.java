package com.example.jhordan.people_mvvm;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.example.jhordan.people_mvvm.databinding.ItemPeopleBindingImpl;
import com.example.jhordan.people_mvvm.databinding.PeopleActivityBindingImpl;
import com.example.jhordan.people_mvvm.databinding.PeopleDetailActivityBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ITEMPEOPLE = 1;

  private static final int LAYOUT_PEOPLEACTIVITY = 2;

  private static final int LAYOUT_PEOPLEDETAILACTIVITY = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.jhordan.people_mvvm.R.layout.item_people, LAYOUT_ITEMPEOPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.jhordan.people_mvvm.R.layout.people_activity, LAYOUT_PEOPLEACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.jhordan.people_mvvm.R.layout.people_detail_activity, LAYOUT_PEOPLEDETAILACTIVITY);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ITEMPEOPLE: {
          if ("layout/item_people_0".equals(tag)) {
            return new ItemPeopleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_people is invalid. Received: " + tag);
        }
        case  LAYOUT_PEOPLEACTIVITY: {
          if ("layout/people_activity_0".equals(tag)) {
            return new PeopleActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for people_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_PEOPLEDETAILACTIVITY: {
          if ("layout/people_detail_activity_0".equals(tag)) {
            return new PeopleDetailActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for people_detail_activity is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "peopleViewModel");
      sKeys.put(2, "peopleDetailViewModel");
      sKeys.put(3, "mainViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/item_people_0", com.example.jhordan.people_mvvm.R.layout.item_people);
      sKeys.put("layout/people_activity_0", com.example.jhordan.people_mvvm.R.layout.people_activity);
      sKeys.put("layout/people_detail_activity_0", com.example.jhordan.people_mvvm.R.layout.people_detail_activity);
    }
  }
}
