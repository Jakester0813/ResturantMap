package com.jakester.resturantmap.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jakester.resturantmap.R;
import com.jakester.resturantmap.adapters.ReviewAdapter;
import com.jakester.resturantmap.interfaces.PlaceDetailsInterface;
import com.jakester.resturantmap.models.DetailResponse;
import com.jakester.resturantmap.models.GetPlacesResponse;
import com.jakester.resturantmap.models.Location;
import com.jakester.resturantmap.models.PlaceDetailsResponse;
import com.jakester.resturantmap.models.Places;
import com.jakester.resturantmap.models.Result;
import com.jakester.resturantmap.util.DetailsUtility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResturantActivity extends AppCompatActivity {

    private PlaceDetailsInterface mInterface;
    private Places mPlace;
    private TextView mAddressText, mPhoneText, mRatingText, mReviewsText;
    private View mPhoneView, mRatingView;
    private RecyclerView mReviewsRecycler;
    private RecyclerView.LayoutManager mReviewsManager;
    private ReviewAdapter mReviewsAdapter;

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
                    loadComponents(deets.getDetails());

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

    private void loadComponents(Result deets){
        getSupportActionBar().setTitle(deets.getName());
        mPhoneView = findViewById(R.id.v_phone);
        mRatingView = findViewById(R.id.v_rating);
        mAddressText = (TextView) findViewById(R.id.tv_address);
        mAddressText.setText(deets.getFormattedAddress());
        mAddressText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Phone number details
        if(deets.getFormattedPhoneNumber().equals("") || deets.getFormattedPhoneNumber().equals(null)){
            mPhoneView.setVisibility(View.GONE);
        }
        else{
            StringBuilder phoneSB = new StringBuilder("Phone Number: ");
            phoneSB.append(deets.getFormattedPhoneNumber());
            mPhoneText = (TextView) findViewById(R.id.tv_phone_contact);
            mPhoneText.setText(phoneSB.toString());
            mPhoneText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        if(deets.getRating().equals("") || deets.getRating().equals(null)){
            mRatingView.setVisibility(View.GONE);
        }
        else{
            StringBuilder ratingSB = new StringBuilder("Rating: ");
            ratingSB.append(deets.getRating()).append("/5");
            mRatingText = (TextView) findViewById(R.id.tv_rating);
            mRatingText.setText(ratingSB.toString());
        }

        if(deets.getReviews().size() >= 0 && deets.getReviews() != null){
            mReviewsText = (TextView) findViewById(R.id.tv_reviews);
            mReviewsText.setText("Reviews");
            mReviewsRecycler = (RecyclerView) findViewById(R.id.rv_reviews);
            mReviewsManager = new LinearLayoutManager(this);
            mReviewsRecycler.setLayoutManager(mReviewsManager);
            mReviewsAdapter = new ReviewAdapter(deets.getReviews());
            mReviewsRecycler.setAdapter(mReviewsAdapter);

        }

    }
}
