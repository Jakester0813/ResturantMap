package com.jakester.resturantmap.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Places implements Parcelable {

    @SerializedName("geometry")
    @Expose
    Geometry mGeometry;

    @SerializedName("icon")
    @Expose
    String mIcon;

    @SerializedName("id")
    @Expose
    String mId;

    @SerializedName("name")
    @Expose
    String mName;

    @SerializedName("place_id")
    @Expose
    String mPlaceId;

    @SerializedName("rating")
    @Expose
    double mRating;

    @SerializedName("formatted_address")
    @Expose
    String mAddress;


    public static final Creator<Places> CREATOR = new Creator<Places>() {
        @Override
        public Places createFromParcel(Parcel in) {
            return new Places(in);
        }

        @Override
        public Places[] newArray(int size) {
            return new Places[size];
        }
    };

    public void setGeometry(Geometry pLocation) {this.mGeometry = pLocation;}

    public Geometry getGeometry() {
        return mGeometry;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String pIcon) {
        mIcon = pIcon;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPlaceId() {
        return mPlaceId;
    }

    public void setPlaceId(String placeId) {
        mPlaceId = placeId;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double rating) {
        mRating = rating;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    protected Places(Parcel in){
        setGeometry((Geometry) in.readParcelable(Geometry.class.getClassLoader()));
        setIcon(in.readString());
        setId(in.readString());
        setName(in.readString());
        setPlaceId(in.readString());
        setRating(in.readDouble());
        setAddress(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mGeometry, i);
        parcel.writeString(mIcon);
        parcel.writeString(mId);
        parcel.writeString(mName);
        parcel.writeString(mPlaceId);
        parcel.writeDouble(mRating);
        parcel.writeString(mAddress);
    }
}
