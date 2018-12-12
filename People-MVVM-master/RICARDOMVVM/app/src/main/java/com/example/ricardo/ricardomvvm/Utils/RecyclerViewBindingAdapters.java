package com.example.ricardo.ricardomvvm.Utils;

import android.databinding.BindingAdapter;
import android.databinding.adapters.ListenerUtil;
import android.support.v7.widget.RecyclerView;

import com.example.ricardo.ricardomvvm.R;

public class RecyclerViewBindingAdapters {

    @BindingAdapter(value = {"onScrollStateChanged", "onScrolled"}, requireAll = false)
    public static void setOnScrollListener(RecyclerView view, final OnScrollStateChanged scrollStateChanged, final OnScrolled scrolled) {
        final RecyclerView.OnScrollListener newValue;
        if (scrollStateChanged == null && scrolled == null) {
            newValue = null;
        } else {
            newValue = new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (scrollStateChanged != null) {
                        scrollStateChanged.onScrollStateChanged(recyclerView, newState);
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (scrolled != null) {
                        scrolled.onScrolled(recyclerView, dx, dy);
                    }
                }
            };
        }
        final RecyclerView.OnScrollListener oldValue = ListenerUtil.trackListener(view, newValue, R.id.rv_list_movies);
        if (oldValue != null) {
            view.removeOnScrollListener(oldValue);
        }
        if (newValue != null) {
            view.addOnScrollListener(newValue);
        }
    }

    public interface OnScrollStateChanged {
        void onScrollStateChanged(RecyclerView recyclerView, int newState);
    }

    public interface OnScrolled {
        void onScrolled(RecyclerView recyclerView, int dx, int dy);
    }
}
