package com.example.webnews.ui.ABP;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;



    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ABP ANANDA fragment");
    }



    public LiveData<String> getText() {
        return mText;
    }
}