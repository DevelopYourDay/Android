package com.example.jhordan.people_mvvm.databinding;
import com.example.jhordan.people_mvvm.R;
import com.example.jhordan.people_mvvm.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemPeopleBindingImpl extends ItemPeopleBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    private OnClickListenerImpl mPeopleViewModelOnItemClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemPeopleBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemPeopleBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.RelativeLayout) bindings[0]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.imagePeople.setTag(null);
        this.itemPeople.setTag(null);
        this.labelMail.setTag(null);
        this.labelName.setTag(null);
        this.labelPhone.setTag(null);
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
        if (BR.peopleViewModel == variableId) {
            setPeopleViewModel((com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPeopleViewModel(@Nullable com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel PeopleViewModel) {
        updateRegistration(0, PeopleViewModel);
        this.mPeopleViewModel = PeopleViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.peopleViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePeopleViewModel((com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangePeopleViewModel(com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel PeopleViewModel, int fieldId) {
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
        java.lang.String peopleViewModelCell = null;
        com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel peopleViewModel = mPeopleViewModel;
        android.view.View.OnClickListener peopleViewModelOnItemClickAndroidViewViewOnClickListener = null;
        java.lang.String peopleViewModelMail = null;
        java.lang.String peopleViewModelPictureProfile = null;
        java.lang.String peopleViewModelFullName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (peopleViewModel != null) {
                    // read peopleViewModel.cell
                    peopleViewModelCell = peopleViewModel.getCell();
                    // read peopleViewModel::onItemClick
                    peopleViewModelOnItemClickAndroidViewViewOnClickListener = (((mPeopleViewModelOnItemClickAndroidViewViewOnClickListener == null) ? (mPeopleViewModelOnItemClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mPeopleViewModelOnItemClickAndroidViewViewOnClickListener).setValue(peopleViewModel));
                    // read peopleViewModel.mail
                    peopleViewModelMail = peopleViewModel.getMail();
                    // read peopleViewModel.pictureProfile
                    peopleViewModelPictureProfile = peopleViewModel.getPictureProfile();
                    // read peopleViewModel.fullName
                    peopleViewModelFullName = peopleViewModel.getFullName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.jhordan.people_mvvm.viewmodel.PeopleDetailViewModel.loadImage(this.imagePeople, peopleViewModelPictureProfile);
            this.itemPeople.setOnClickListener(peopleViewModelOnItemClickAndroidViewViewOnClickListener);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.labelMail, peopleViewModelMail);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.labelName, peopleViewModelFullName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.labelPhone, peopleViewModelCell);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel value;
        public OnClickListenerImpl setValue(com.example.jhordan.people_mvvm.viewmodel.ItemPeopleViewModel value) {
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
        flag 0 (0x1L): peopleViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}