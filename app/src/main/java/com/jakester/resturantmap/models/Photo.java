package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jake on 8/23/2017.
 */

public class Photo {
    @SerializedName("height")
    @Expose
    int mHeight;

    @SerializedName("width")
    @Expose
    int mWidth;

    @SerializedName("photo_reference")
    @Expose
    String mPhotoReference;

    public void setHeight(int pHeight) {this.mHeight = pHeight;}

    public int getHeight() {
        return mHeight;
    }

    public void setWidth(int pWidth) {
        this.mWidth = pWidth;
    }

    public int getWidth() {return mWidth;}

    public void setPhotoReference(String pPhotoReference) {
        mPhotoReference = pPhotoReference;
    }

    public String getPhotoReference() {
        return mPhotoReference;
    }
}
