package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 8/23/2017.
 */

public class Location {
    @SerializedName("lat")
    @Expose
    double latitude;

    @SerializedName("lng")
    @Expose
    double longitude;

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
}
