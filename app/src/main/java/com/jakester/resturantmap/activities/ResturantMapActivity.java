package com.jakester.resturantmap.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jakester.resturantmap.R;
import com.jakester.resturantmap.interfaces.APIInterface;
import com.jakester.resturantmap.models.GetPlacesResponse;
import com.jakester.resturantmap.models.Places;
import com.jakester.resturantmap.util.APIUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResturantMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private APIInterface mInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        loadPlaces();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void loadPlaces() {
        mInterface = APIUtility.getPlacesService();
        mInterface.getPlaces().enqueue(new Callback<GetPlacesResponse>() {
            @Override
            public void onResponse(Call<GetPlacesResponse> call, Response<GetPlacesResponse> response) {

                if(response.isSuccessful()) {
                   Places places = response.body().getPlaces();
                }else {
                    int statusCode  = response.code();
                    switch (statusCode){
                        case 404:
                            Toast.makeText(ResturantMapActivity.this, "Your request cannot be found", Toast.LENGTH_SHORT).show();
                            break;
                        case 408:
                            Toast.makeText(ResturantMapActivity.this, "Your request has timed out", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ResturantMapActivity.this, "Something's wrong with the server", Toast.LENGTH_SHORT).show();
                            break;
                        case 503:
                            Toast.makeText(ResturantMapActivity.this, "The service is unavailable", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<GetPlacesResponse> call, Throwable t) {
                Toast.makeText(ResturantMapActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
