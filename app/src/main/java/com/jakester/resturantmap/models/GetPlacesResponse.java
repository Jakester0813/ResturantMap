package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPlacesResponse {

    @SerializedName("results")
    @Expose
    Places mPlaces;


    public Places getPlaces() {
        return mPlaces;
    }

    public void setPlaces(Places places) {
        mPlaces = places;
    }

}
