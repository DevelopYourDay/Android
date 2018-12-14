package com.example.ricardo.ricardomvvm.databinding;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMovieBindingImpl extends ActivityMovieBinding implements com.example.ricardo.ricardomvvm.generated.callback.OnScrolled.Listener, com.example.ricardo.ricardomvvm.generated.callback.OnRefreshListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline, 3);
    }
    // views
    // variables
    @Nullable
    private final com.example.ricardo.ricardomvvm.Utils.RecyclerViewBindingAdapters.OnScrolled mCallback2;
    @Nullable
    private final android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMovieBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityMovieBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.support.constraint.Guideline) bindings[3]
            , (android.support.v7.widget.RecyclerView) bindings[1]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[0]
            , (android.widget.ProgressBar) bindings[2]
            );
        this.rvListMovies.setTag(null);
        this.swipeMovieListRefresh.setTag(null);
        this.widgetProgressBarListMovies.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.example.ricardo.ricardomvvm.generated.callback.OnScrolled(this, 2);
        mCallback1 = new com.example.ricardo.ricardomvvm.generated.callback.OnRefreshListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.movieViewModel == variableId) {
            setMovieViewModel((com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMovieViewModel(@Nullable com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel MovieViewModel) {
        this.mMovieViewModel = MovieViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.movieViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMovieViewModelIsLoading((android.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeMovieViewModelMovieProgress((android.databinding.ObservableInt) object, fieldId);
            case 2 :
                return onChangeMovieViewModelMovieRecycler((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMovieViewModelIsLoading(android.databinding.ObservableBoolean MovieViewModelIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMovieViewModelMovieProgress(android.databinding.ObservableInt MovieViewModelMovieProgress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMovieViewModelMovieRecycler(android.databinding.ObservableInt MovieViewModelMovieRecycler, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
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
        int movieViewModelMovieProgressGet = 0;
        android.databinding.ObservableBoolean movieViewModelIsLoading = null;
        boolean movieViewModelIsLoadingGet = false;
        android.databinding.ObservableInt movieViewModelMovieProgress = null;
        android.databinding.ObservableInt movieViewModelMovieRecycler = null;
        com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel movieViewModel = mMovieViewModel;
        int movieViewModelMovieRecyclerGet = 0;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (movieViewModel != null) {
                        // read movieViewModel.isLoading
                        movieViewModelIsLoading = movieViewModel.isLoading;
                    }
                    updateRegistration(0, movieViewModelIsLoading);


                    if (movieViewModelIsLoading != null) {
                        // read movieViewModel.isLoading.get()
                        movieViewModelIsLoadingGet = movieViewModelIsLoading.get();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (movieViewModel != null) {
                        // read movieViewModel.movieProgress
                        movieViewModelMovieProgress = movieViewModel.movieProgress;
                    }
                    updateRegistration(1, movieViewModelMovieProgress);


                    if (movieViewModelMovieProgress != null) {
                        // read movieViewModel.movieProgress.get()
                        movieViewModelMovieProgressGet = movieViewModelMovieProgress.get();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (movieViewModel != null) {
                        // read movieViewModel.movieRecycler
                        movieViewModelMovieRecycler = movieViewModel.movieRecycler;
                    }
                    updateRegistration(2, movieViewModelMovieRecycler);


                    if (movieViewModelMovieRecycler != null) {
                        // read movieViewModel.movieRecycler.get()
                        movieViewModelMovieRecyclerGet = movieViewModelMovieRecycler.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            this.rvListMovies.setVisibility(movieViewModelMovieRecyclerGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            com.example.ricardo.ricardomvvm.Utils.RecyclerViewBindingAdapters.setOnScrollListener(this.rvListMovies, (com.example.ricardo.ricardomvvm.Utils.RecyclerViewBindingAdapters.OnScrollStateChanged)null, mCallback2);
            this.swipeMovieListRefresh.setOnRefreshListener(mCallback1);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            this.swipeMovieListRefresh.setRefreshing(movieViewModelIsLoadingGet);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            this.widgetProgressBarListMovies.setVisibility(movieViewModelMovieProgressGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnScrolled(int sourceId , android.support.v7.widget.RecyclerView callbackArg_0, int callbackArg_1, int callbackArg_2) {
        // localize variables for thread safety
        // movieViewModel != null
        boolean movieViewModelJavaLangObjectNull = false;
        // movieViewModel
        com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel movieViewModel = mMovieViewModel;



        movieViewModelJavaLangObjectNull = (movieViewModel) != (null);
        if (movieViewModelJavaLangObjectNull) {





            movieViewModel.onScrolled(callbackArg_0, callbackArg_1, callbackArg_2);
        }
    }
    public final void _internalCallbackOnRefresh(int sourceId ) {
        // localize variables for thread safety
        // movieViewModel != null
        boolean movieViewModelJavaLangObjectNull = false;
        // movieViewModel
        com.example.ricardo.ricardomvvm.viewmodel.MovieViewModel movieViewModel = mMovieViewModel;



        movieViewModelJavaLangObjectNull = (movieViewModel) != (null);
        if (movieViewModelJavaLangObjectNull) {


            movieViewModel.onRefresh();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): movieViewModel.isLoading
        flag 1 (0x2L): movieViewModel.movieProgress
        flag 2 (0x3L): movieViewModel.movieRecycler
        flag 3 (0x4L): movieViewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}