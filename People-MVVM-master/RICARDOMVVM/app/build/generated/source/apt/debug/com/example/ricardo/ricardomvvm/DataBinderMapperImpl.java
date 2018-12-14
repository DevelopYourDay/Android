package com.example.ricardo.ricardomvvm;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieBindingImpl;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieDetailsBindingImpl;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsInformationBindingImpl;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsReviewBindingImpl;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsTrailerBindingImpl;
import com.example.ricardo.ricardomvvm.databinding.ItemMovieBindingImpl;
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
  private static final int LAYOUT_ACTIVITYMOVIE = 1;

  private static final int LAYOUT_ACTIVITYMOVIEDETAILS = 2;

  private static final int LAYOUT_FRAGMENTMOVIEDETAILSINFORMATION = 3;

  private static final int LAYOUT_FRAGMENTMOVIEDETAILSREVIEW = 4;

  private static final int LAYOUT_FRAGMENTMOVIEDETAILSTRAILER = 5;

  private static final int LAYOUT_ITEMMOVIE = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.ricardo.ricardomvvm.R.layout.activity_movie, LAYOUT_ACTIVITYMOVIE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.ricardo.ricardomvvm.R.layout.activity_movie_details, LAYOUT_ACTIVITYMOVIEDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_information, LAYOUT_FRAGMENTMOVIEDETAILSINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_review, LAYOUT_FRAGMENTMOVIEDETAILSREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_trailer, LAYOUT_FRAGMENTMOVIEDETAILSTRAILER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.ricardo.ricardomvvm.R.layout.item_movie, LAYOUT_ITEMMOVIE);
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
        case  LAYOUT_ACTIVITYMOVIE: {
          if ("layout/activity_movie_0".equals(tag)) {
            return new ActivityMovieBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_movie is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMOVIEDETAILS: {
          if ("layout/activity_movie_details_0".equals(tag)) {
            return new ActivityMovieDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_movie_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMOVIEDETAILSINFORMATION: {
          if ("layout/fragment_movie_details_information_0".equals(tag)) {
            return new FragmentMovieDetailsInformationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_movie_details_information is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMOVIEDETAILSREVIEW: {
          if ("layout/fragment_movie_details_review_0".equals(tag)) {
            return new FragmentMovieDetailsReviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_movie_details_review is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMOVIEDETAILSTRAILER: {
          if ("layout/fragment_movie_details_trailer_0".equals(tag)) {
            return new FragmentMovieDetailsTrailerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_movie_details_trailer is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMMOVIE: {
          if ("layout/item_movie_0".equals(tag)) {
            return new ItemMovieBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_movie is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(6);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "movieViewModel");
      sKeys.put(2, "movieDetailsViewModel");
      sKeys.put(3, "movieItemViewModel");
      sKeys.put(4, "movieDetailViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_movie_0", com.example.ricardo.ricardomvvm.R.layout.activity_movie);
      sKeys.put("layout/activity_movie_details_0", com.example.ricardo.ricardomvvm.R.layout.activity_movie_details);
      sKeys.put("layout/fragment_movie_details_information_0", com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_information);
      sKeys.put("layout/fragment_movie_details_review_0", com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_review);
      sKeys.put("layout/fragment_movie_details_trailer_0", com.example.ricardo.ricardomvvm.R.layout.fragment_movie_details_trailer);
      sKeys.put("layout/item_movie_0", com.example.ricardo.ricardomvvm.R.layout.item_movie);
    }
  }
}
