package com.example.e5813.livedatatest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.widget.EditText;

public class MainViewModel extends ViewModel {

    private  MutableLiveData<String> currentRandomFruitName = new MutableLiveData<>();
    private  MutableLiveData<String> _displayedEditTextContent = new MutableLiveData<>();


    public final LiveData<String> getCurrentRandomFruitName() {
            currentRandomFruitName.setValue("banana");
        return currentRandomFruitName;
    }

    public final void onChangeRandomFruitClick() {
        currentRandomFruitName.setValue("ananas");
    }



}
