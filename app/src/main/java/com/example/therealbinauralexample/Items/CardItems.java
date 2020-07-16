package com.example.therealbinauralexample.Items;

import android.content.Intent;
import android.view.View;

public class CardItems {
    private int mImage;
    private String mTextTitle;
    private String mTextDiscription;


    public CardItems(int image, String textTitle, String textDiscription){
        mImage = image;
        mTextTitle = textTitle;
        mTextDiscription = textDiscription;

    }

    public void changeText1(String text) {
        mTextTitle = text;
    }

    public int getImage() {
        return mImage;
    }

    public String getTextTitle() {
        return mTextTitle;
    }

    public String getTextDiscription() {
        return mTextDiscription;
    }
}
