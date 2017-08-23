package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPlacesResponse {

    @SerializedName("results")
    @Expose
    List<Places> mPlaces;


    public List<Places> getPlaces() {
        return mPlaces;
    }

    public void setPlaces(List<Places> places) {
        mPlaces = places;
    }

}
