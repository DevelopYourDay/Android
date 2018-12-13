package com.example.jhordan.people_mvvm.databinding;
import com.example.jhordan.people_mvvm.R;
import com.example.jhordan.people_mvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PeopleActivityBindingImpl extends PeopleActivityBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 5);
    }
    // views
    @NonNull
    private final android.support.design.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mMainViewModelOnClickFabLoadAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public PeopleActivityBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private PeopleActivityBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.support.design.widget.FloatingActionButton) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.support.v7.widget.RecyclerView) bindings[3]
            , (android.widget.ProgressBar) bindings[1]
            , (android.support.v7.widget.Toolbar) bindings[5]
            );
        this.fab.setTag(null);
        this.labelStatus.setTag(null);
        this.listPeople.setTag(null);
        this.mboundView0 = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressPeople.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.mainViewModel == variableId) {
            setMainViewModel((com.example.jhordan.people_mvvm.viewmodel.PeopleViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainViewModel(@Nullable com.example.jhordan.people_mvvm.viewmodel.PeopleViewModel MainViewModel) {
        this.mMainViewModel = MainViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.mainViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMainViewModelPeopleProgress((android.databinding.ObservableInt) object, fieldId);
            case 1 :
                return onChangeMainViewModelPeopleRecycler((android.databinding.ObservableInt) object, fieldId);
            case 2 :
                return onChangeMainViewModelPeopleLabel((android.databinding.ObservableInt) object, fieldId);
            case 3 :
                return onChangeMainViewModelMessageLabel((android.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMainViewModelPeopleProgress(android.databinding.ObservableInt MainViewModelPeopleProgress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMainViewModelPeopleRecycler(android.databinding.ObservableInt MainViewModelPeopleRecycler, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMainViewModelPeopleLabel(android.databinding.ObservableInt MainViewModelPeopleLabel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMainViewModelMessageLabel(android.databinding.ObservableField<java.lang.String> MainViewModelMessageLabel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        android.view.View.OnClickListener mainViewModelOnClickFabLoadAndroidViewViewOnClickListener = null;
        android.databinding.ObservableInt mainViewModelPeopleProgress = null;
        java.lang.String mainViewModelMessageLabelGet = null;
        int mainViewModelPeopleProgressGet = 0;
        com.example.jhordan.people_mvvm.viewmodel.PeopleViewModel mainViewModel = mMainViewModel;
        int mainViewModelPeopleLabelGet = 0;
        android.databinding.ObservableInt mainViewModelPeopleRecycler = null;
        android.databinding.ObservableInt mainViewModelPeopleLabel = null;
        int mainViewModelPeopleRecyclerGet = 0;
        android.databinding.ObservableField<java.lang.String> mainViewModelMessageLabel = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x30L) != 0) {

                    if (mainViewModel != null) {
                        // read mainViewModel::onClickFabLoad
                        mainViewModelOnClickFabLoadAndroidViewViewOnClickListener = (((mMainViewModelOnClickFabLoadAndroidViewViewOnClickListener == null) ? (mMainViewModelOnClickFabLoadAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mMainViewModelOnClickFabLoadAndroidViewViewOnClickListener).setValue(mainViewModel));
                    }
            }
            if ((dirtyFlags & 0x31L) != 0) {

                    if (mainViewModel != null) {
                        // read mainViewModel.peopleProgress
                        mainViewModelPeopleProgress = mainViewModel.peopleProgress;
                    }
                    updateRegistration(0, mainViewModelPeopleProgress);


                    if (mainViewModelPeopleProgress != null) {
                        // read mainViewModel.peopleProgress.get()
                        mainViewModelPeopleProgressGet = mainViewModelPeopleProgress.get();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (mainViewModel != null) {
                        // read mainViewModel.peopleRecycler
                        mainViewModelPeopleRecycler = mainViewModel.peopleRecycler;
                    }
                    updateRegistration(1, mainViewModelPeopleRecycler);


                    if (mainViewModelPeopleRecycler != null) {
                        // read mainViewModel.peopleRecycler.get()
                        mainViewModelPeopleRecyclerGet = mainViewModelPeopleRecycler.get();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (mainViewModel != null) {
                        // read mainViewModel.peopleLabel
                        mainViewModelPeopleLabel = mainViewModel.peopleLabel;
                    }
                    updateRegistration(2, mainViewModelPeopleLabel);


                    if (mainViewModelPeopleLabel != null) {
                        // read mainViewModel.peopleLabel.get()
                        mainViewModelPeopleLabelGet = mainViewModelPeopleLabel.get();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (mainViewModel != null) {
                        // read mainViewModel.messageLabel
                        mainViewModelMessageLabel = mainViewModel.messageLabel;
                    }
                    updateRegistration(3, mainViewModelMessageLabel);


                    if (mainViewModelMessageLabel != null) {
                        // read mainViewModel.messageLabel.get()
                        mainViewModelMessageLabelGet = mainViewModelMessageLabel.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            this.fab.setOnClickListener(mainViewModelOnClickFabLoadAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.labelStatus, mainViewModelMessageLabelGet);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            this.labelStatus.setVisibility(mainViewModelPeopleLabelGet);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            this.listPeople.setVisibility(mainViewModelPeopleRecyclerGet);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            this.progressPeople.setVisibility(mainViewModelPeopleProgressGet);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.jhordan.people_mvvm.viewmodel.PeopleViewModel value;
        public OnClickListenerImpl setValue(com.example.jhordan.people_mvvm.viewmodel.PeopleViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClickFabLoad(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mainViewModel.peopleProgress
        flag 1 (0x2L): mainViewModel.peopleRecycler
        flag 2 (0x3L): mainViewModel.peopleLabel
        flag 3 (0x4L): mainViewModel.messageLabel
        flag 4 (0x5L): mainViewModel
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}