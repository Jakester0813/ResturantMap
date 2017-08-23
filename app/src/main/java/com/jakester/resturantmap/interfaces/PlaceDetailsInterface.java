package com.jakester.resturantmap.interfaces;

import com.jakester.resturantmap.models.DetailResponse;
import com.jakester.resturantmap.models.GetPlacesResponse;
import com.jakester.resturantmap.models.PlaceDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jake on 8/23/2017.
 */

public interface PlaceDetailsInterface {
    @GET("maps/api/place/details/json?key=AIzaSyB-bpw0ollWA5AKpT11Y2CL2qPFs4kC_dk")
    Call<PlaceDetailsResponse> getDetails(@Query("placeid") String pPlaceId);
}
