package com.example.ricardo.ricardomvvm.databinding;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMovieDetailsInformationBindingImpl extends FragmentMovieDetailsInformationBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline3, 6);
        sViewsWithIds.put(R.id.guideline4, 7);
        sViewsWithIds.put(R.id.guideline5, 8);
        sViewsWithIds.put(R.id.guideline6, 9);
        sViewsWithIds.put(R.id.img_details_movie_mark_favorite, 10);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMovieDetailsInformationBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentMovieDetailsInformationBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.constraint.Guideline) bindings[6]
            , (android.support.constraint.Guideline) bindings[7]
            , (android.support.constraint.Guideline) bindings[8]
            , (android.support.constraint.Guideline) bindings[9]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        ensureBindingComponentIsNotNull(com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel.class);
        this.imgDetailsMovieCover.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvMovieDescriptions.setTag(null);
        this.tvMovieDuration.setTag(null);
        this.tvMovieRating.setTag(null);
        this.tvMovieYear.setTag(null);
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
        if (BR.movieDetailsViewModel == variableId) {
            setMovieDetailsViewModel((com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMovieDetailsViewModel(@Nullable com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel MovieDetailsViewModel) {
        this.mMovieDetailsViewModel = MovieDetailsViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.movieDetailsViewModel);
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
        java.lang.String movieDetailsViewModelMovieDetailsUtlImage = null;
        com.example.ricardo.ricardomvvm.viewmodel.MovieDetailsViewModel movieDetailsViewModel = mMovieDetailsViewModel;
        java.lang.String movieDetailsViewModelMovieDetailsDescription = null;
        java.lang.String movieDetailsViewModelMovieDetailsRating = null;
        java.lang.String movieDetailsViewModelMovieDetailsDuration = null;
        com.example.ricardo.ricardomvvm.model.MovieDetail movieDetailsViewModelMovieDetails = null;
        java.lang.String movieDetailsViewModelMovieDetailsYear = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (movieDetailsViewModel != null) {
                    // read movieDetailsViewModel.movieDetails
                    movieDetailsViewModelMovieDetails = movieDetailsViewModel.getMovieDetails();
                }


                if (movieDetailsViewModelMovieDetails != null) {
                    // read movieDetailsViewModel.movieDetails.utlImage
                    movieDetailsViewModelMovieDetailsUtlImage = movieDetailsViewModelMovieDetails.getUtlImage();
                    // read movieDetailsViewModel.movieDetails.description
                    movieDetailsViewModelMovieDetailsDescription = movieDetailsViewModelMovieDetails.getDescription();
                    // read movieDetailsViewModel.movieDetails.rating
                    movieDetailsViewModelMovieDetailsRating = movieDetailsViewModelMovieDetails.getRating();
                    // read movieDetailsViewModel.movieDetails.duration
                    movieDetailsViewModelMovieDetailsDuration = movieDetailsViewModelMovieDetails.getDuration();
                    // read movieDetailsViewModel.movieDetails.year
                    movieDetailsViewModelMovieDetailsYear = movieDetailsViewModelMovieDetails.getYear();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.mBindingComponent.getMovieDetailsViewModel().loadImage(this.imgDetailsMovieCover, movieDetailsViewModelMovieDetailsUtlImage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvMovieDescriptions, movieDetailsViewModelMovieDetailsDescription);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvMovieDuration, movieDetailsViewModelMovieDetailsDuration);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvMovieRating, movieDetailsViewModelMovieDetailsRating);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvMovieYear, movieDetailsViewModelMovieDetailsYear);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): movieDetailsViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}