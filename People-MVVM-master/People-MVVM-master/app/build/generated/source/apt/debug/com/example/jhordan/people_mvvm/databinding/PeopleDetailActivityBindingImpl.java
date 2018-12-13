package com.example.jhordan.people_mvvm.databinding;
import com.example.jhordan.people_mvvm.R;
import com.example.jhordan.people_mvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PeopleDetailActivityBindingImpl extends PeopleDetailActivityBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 8);
        sViewsWithIds.put(R.id.people_card, 9);
        sViewsWithIds.put(R.id.image_user, 10);
        sViewsWithIds.put(R.id.image_phone, 11);
        sViewsWithIds.put(R.id.image_mail, 12);
        sViewsWithIds.put(R.id.image_home, 13);
        sViewsWithIds.put(R.id.image_gender, 14);
        sViewsWithIds.put(R.id.fab_star, 15);
    }
    // views
    @NonNull
    private final android.support.design.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.support.design.widget.CollapsingToolbarLayout mboundView1;
    @NonNull
    private final android.widget.ImageView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PeopleDetailActivityBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private PeopleDetailActivityBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.design.widget.FloatingActionButton) bindings[15]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[10]
            , (android.support.v7.widget.CardView) bindings[9]
            , (android.support.v7.widget.Toolbar) bindings[8]
            );
        this.mboundView0 = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.design.widget.CollapsingToolbarLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.ImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
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
        if (BR.peopleDetailViewModel == variableId) {
            setPeopleDetailViewModel((com.example.jhordan.people_mvvm.viewmodel.PeopleDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPeopleDetailViewModel(@Nullable com.example.jhordan.people_mvvm.viewmodel.PeopleDetailViewModel PeopleDetailViewModel) {
        this.mPeopleDetailViewModel = PeopleDetailViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.peopleDetailViewModel);
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
        java.lang.String peopleDetailViewModelFullUserName = null;
        java.lang.String peopleDetailViewModelCell = null;
        int peopleDetailViewModelEmailVisibility = 0;
        java.lang.String peopleDetailViewModelPictureProfile = null;
        java.lang.String peopleDetailViewModelAddress = null;
        java.lang.String peopleDetailViewModelGender = null;
        com.example.jhordan.people_mvvm.viewmodel.PeopleDetailViewModel peopleDetailViewModel = mPeopleDetailViewModel;
        java.lang.String peopleDetailViewModelUserName = null;
        java.lang.String peopleDetailViewModelEmail = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (peopleDetailViewModel != null) {
                    // read peopleDetailViewModel.fullUserName
                    peopleDetailViewModelFullUserName = peopleDetailViewModel.getFullUserName();
                    // read peopleDetailViewModel.cell
                    peopleDetailViewModelCell = peopleDetailViewModel.getCell();
                    // read peopleDetailViewModel.emailVisibility
                    peopleDetailViewModelEmailVisibility = peopleDetailViewModel.getEmailVisibility();
                    // read peopleDetailViewModel.pictureProfile
                    peopleDetailViewModelPictureProfile = peopleDetailViewModel.getPictureProfile();
                    // read peopleDetailViewModel.address
                    peopleDetailViewModelAddress = peopleDetailViewModel.getAddress();
                    // read peopleDetailViewModel.gender
                    peopleDetailViewModelGender = peopleDetailViewModel.getGender();
                    // read peopleDetailViewModel.userName
                    peopleDetailViewModelUserName = peopleDetailViewModel.getUserName();
                    // read peopleDetailViewModel.email
                    peopleDetailViewModelEmail = peopleDetailViewModel.getEmail();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.mboundView1.setTitle(peopleDetailViewModelFullUserName);
            com.example.jhordan.people_mvvm.viewmodel.PeopleDetailViewModel.loadImage(this.mboundView2, peopleDetailViewModelPictureProfile);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, peopleDetailViewModelUserName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, peopleDetailViewModelCell);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, peopleDetailViewModelEmail);
            this.mboundView5.setVisibility(peopleDetailViewModelEmailVisibility);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, peopleDetailViewModelGender);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, peopleDetailViewModelAddress);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): peopleDetailViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}