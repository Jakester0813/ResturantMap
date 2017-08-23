package com.jakester.resturantmap.util;


import com.jakester.resturantmap.interfaces.APIInterface;
import com.jakester.resturantmap.network.RestClient;

/**
 * Created by Jake on 6/22/2017.
 */

public class APIUtility {

    public static APIInterface getPlacesService() {
        return RestClient.getClient().create(APIInterface.class);
    }
}
