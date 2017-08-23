package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 8/23/2017.
 */

public class PlaceDetailsResponse {
    @SerializedName("result")
    @Expose
    Result mResults;

    public Result getDetails() {
        return mResults;
    }

    public void setDetails(Result results) {
        mResults = results;
    }
}
