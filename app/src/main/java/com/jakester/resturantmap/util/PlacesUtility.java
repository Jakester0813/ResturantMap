package com.jakester.resturantmap.util;


import com.jakester.resturantmap.interfaces.PlaceDetailsInterface;
import com.jakester.resturantmap.interfaces.PlaceSearchInterface;
import com.jakester.resturantmap.network.RestClient;

/**
 * Created by Jake on 6/22/2017.
 */

public class PlacesUtility {

    public static PlaceSearchInterface getPlacesService() {
        return RestClient.getClient().create(PlaceSearchInterface.class);
    }
}
