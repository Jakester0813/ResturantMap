package com.jakester.resturantmap.interfaces;

import com.jakester.resturantmap.models.GetPlacesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jake on 6/22/2017.
 */

public interface PlaceSearchInterface {
    @GET("maps/api/place/nearbysearch/json?location=37.7749,-122.431297&radius=500&types=resturants&key=AIzaSyB-bpw0ollWA5AKpT11Y2CL2qPFs4kC_dk")
    Call<GetPlacesResponse> getPlaces();
}
