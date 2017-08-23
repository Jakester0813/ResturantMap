package com.jakester.resturantmap.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jake on 8/23/2017.
 */

public class Photo implements Parcelable{
    @SerializedName("height")
    @Expose
    int mHeight;

    @SerializedName("width")
    @Expose
    int mWidth;

    @SerializedName("photo_reference")
    @Expose
    String mPhotoReference;

    protected Photo(Parcel in) {
        mHeight = in.readInt();
        mWidth = in.readInt();
        mPhotoReference = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mHeight);
        parcel.writeInt(mWidth);
        parcel.writeString(mPhotoReference);
    }
}
