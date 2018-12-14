package com.example.e5813.livedatatest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FakeRepo {

    public List<String> fruitNames = new ArrayList<>();

    private  MutableLiveData<String> _currentRandomFruitName;



    public FakeRepo() {
        this.fruitNames = fruitNames;
        setFruitNames();
        this._currentRandomFruitName.setValue(fruitNames.get(0));
    }

    public void setFruitNames() {
        fruitNames.add("banana");
        fruitNames.add("morango");
        fruitNames.add("ananas");
        this.fruitNames = fruitNames;
    }


    public final LiveData<String> getCurrentRandomFruitName() {
        return _currentRandomFruitName;
    }

    public String getRandomFruitName() {
        Random random = new Random();
        return fruitNames.get(random.nextInt(fruitNames.size()));
    }

    public final void changeCurrentRandomFruitName() {
        _currentRandomFruitName.setValue(this.getRandomFruitName());
    }



}
