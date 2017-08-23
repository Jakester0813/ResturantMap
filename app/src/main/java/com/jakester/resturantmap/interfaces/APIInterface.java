package com.jakester.resturantmap.interfaces;

import com.jakester.resturantmap.models.GetPlacesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jake on 6/22/2017.
 */

public interface APIInterface {
    @GET("maps/api/place/nearbysearch/json?key=AIzaSyB-bpw0ollWA5AKpT11Y2CL2qPFs4kC_dk&location=37.7749,122.4194&radius=50&type=restaurant")
    Call<GetPlacesResponse> getPlaces();
}
