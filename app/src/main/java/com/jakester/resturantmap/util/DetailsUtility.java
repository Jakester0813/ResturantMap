package com.jakester.resturantmap.util;


import com.jakester.resturantmap.interfaces.PlaceDetailsInterface;
import com.jakester.resturantmap.network.RestClient;

/**
 * Created by Jake on 6/22/2017.
 */

public class DetailsUtility {

    public static PlaceDetailsInterface getDetailsService() {
        return RestClient.getClient().create(PlaceDetailsInterface.class);
    }
}
