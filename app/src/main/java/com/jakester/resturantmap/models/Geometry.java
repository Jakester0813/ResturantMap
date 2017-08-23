package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 8/23/2017.
 */

public class Geometry {

    @SerializedName("location")
    @Expose
    Location mLocation;

    public void setLocation(Location pLocation) {this.mLocation = pLocation;}

    public Location getLocation() {
        return mLocation;
    }
}
