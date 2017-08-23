package com.jakester.resturantmap.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 8/23/2017.
 */

public class Location implements Parcelable{
    @SerializedName("lat")
    @Expose
    double latitude;

    @SerializedName("lng")
    @Expose
    double longitude;

    protected Location(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(int pLat) {
        latitude = pLat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int pLng) {
        longitude = pLng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }

}
