package com.example.therealbinauralexample;

public class SecondPageItem {
    private int mSecondPageImage;
    private String mSecondPageTitle;
    private String mSecondPageDiscription;

    public SecondPageItem(int image, String textTitle, String textDiscription){
        mSecondPageImage = image;
        mSecondPageTitle = textTitle;
        mSecondPageDiscription = textDiscription;
    }

    public int getSecondPageImage() {
        return mSecondPageImage;
    }

    public String getSecondPageTitle() {
        return mSecondPageTitle;
    }

    public String getSecondPageDiscription() {
        return mSecondPageDiscription;
    }
}
