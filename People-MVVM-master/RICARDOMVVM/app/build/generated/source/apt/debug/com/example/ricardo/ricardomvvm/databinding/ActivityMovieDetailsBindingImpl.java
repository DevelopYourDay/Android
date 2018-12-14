package com.example.ricardo.ricardomvvm.databinding;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMovieDetailsBindingImpl extends ActivityMovieDetailsBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar_movie_details, 2);
        sViewsWithIds.put(R.id.tabLayout_movie_details, 3);
        sViewsWithIds.put(R.id.tabItem_movie_details_information, 4);
        sViewsWithIds.put(R.id.tabItem_movie_details_trailers, 5);
        sViewsWithIds.put(R.id.tabItem_movie_details_reviews, 6);
        sViewsWithIds.put(R.id.tabItem_movie_details_viewpager, 7);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMovieDetailsBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityMovieDetailsBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.constraint.ConstraintLayout) bindings[0]
            , (android.support.design.widget.TabItem) bindings[4]
            , (android.support.design.widget.TabItem) bindings[6]
            , (android.support.design.widget.TabItem) bindings[5]
            , (android.support.v4.view.ViewPager) bindings[7]
            , (android.support.design.widget.TabLayout) bindings[3]
            , (android.support.v7.widget.Toolbar) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mainLayout.setTag(null);
        this.tvMovieTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.movieDetailViewModel == variableId) {
            setMovieDetailViewModel((com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMovieDetailViewModel(@Nullable com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel MovieDetailViewModel) {
        this.mMovieDetailViewModel = MovieDetailViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.movieDetailViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel movieDetailViewModel = mMovieDetailViewModel;
        java.lang.String movieDetailViewModelTitle = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (movieDetailViewModel != null) {
                    // read movieDetailViewModel.title
                    movieDetailViewModelTitle = movieDetailViewModel.getTitle();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvMovieTitle, movieDetailViewModelTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): movieDetailViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}