package com.example.ricardo.ricardomvvm.databinding;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemMovieBindingImpl extends ItemMovieBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mMovieItemViewModelOnItemClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemMovieBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ItemMovieBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[1]
            );
        this.imgCoverMovie.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.movieItemViewModel == variableId) {
            setMovieItemViewModel((com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMovieItemViewModel(@Nullable com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel MovieItemViewModel) {
        updateRegistration(0, MovieItemViewModel);
        this.mMovieItemViewModel = MovieItemViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.movieItemViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMovieItemViewModel((com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMovieItemViewModel(com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel MovieItemViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        android.view.View.OnClickListener movieItemViewModelOnItemClickAndroidViewViewOnClickListener = null;
        com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel movieItemViewModel = mMovieItemViewModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (movieItemViewModel != null) {
                    // read movieItemViewModel::onItemClick
                    movieItemViewModelOnItemClickAndroidViewViewOnClickListener = (((mMovieItemViewModelOnItemClickAndroidViewViewOnClickListener == null) ? (mMovieItemViewModelOnItemClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mMovieItemViewModelOnItemClickAndroidViewViewOnClickListener).setValue(movieItemViewModel));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.imgCoverMovie.setOnClickListener(movieItemViewModelOnItemClickAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel value;
        public OnClickListenerImpl setValue(com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onItemClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): movieItemViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}