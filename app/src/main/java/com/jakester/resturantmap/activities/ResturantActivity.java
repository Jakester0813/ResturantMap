package com.jakester.resturantmap.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jakester.resturantmap.R;
import com.jakester.resturantmap.interfaces.PlaceDetailsInterface;
import com.jakester.resturantmap.models.DetailResponse;
import com.jakester.resturantmap.models.GetPlacesResponse;
import com.jakester.resturantmap.models.Location;
import com.jakester.resturantmap.models.PlaceDetailsResponse;
import com.jakester.resturantmap.models.Places;
import com.jakester.resturantmap.util.DetailsUtility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResturantActivity extends AppCompatActivity {

    private PlaceDetailsInterface mInterface;
    private Places mPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant);
        mPlace = getIntent().getParcelableExtra("place");
        loadDetails(mPlace.getPlaceId());
    }

    public void loadDetails(String pPlaceId) {
        mInterface = DetailsUtility.getDetailsService();
        mInterface.getDetails(pPlaceId).enqueue(new Callback<PlaceDetailsResponse>() {
            @Override
            public void onResponse(Call<PlaceDetailsResponse> call, Response<PlaceDetailsResponse> response) {

                if(response.isSuccessful()) {
                    PlaceDetailsResponse deets = response.body();
                    //List<PlaceDetails> details = response.body().getDetails();
                    //details.getAddress();

                }else {
                    int statusCode  = response.code();
                    switch (statusCode){
                        case 404:
                            Toast.makeText(ResturantActivity.this, "Your request cannot be found", Toast.LENGTH_SHORT).show();
                            break;
                        case 408:
                            Toast.makeText(ResturantActivity.this, "Your request has timed out", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ResturantActivity.this, "Something's wrong with the server", Toast.LENGTH_SHORT).show();
                            break;
                        case 503:
                            Toast.makeText(ResturantActivity.this, "The service is unavailable", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<PlaceDetailsResponse> call, Throwable t) {
                Toast.makeText(ResturantActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
