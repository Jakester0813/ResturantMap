package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Places {

    @SerializedName("geometry")
    @Expose
    Geometry mGeometry;

    @SerializedName("icon")
    @Expose
    String mIcon;

    @SerializedName("id")
    @Expose
    String mId;

    @SerializedName("name")
    @Expose
    String mName;

    @SerializedName("photos")
    @Expose
    List<Photo> mPhotos;


    @SerializedName("place_id")
    @Expose
    String mPlaceId;

    @SerializedName("rating")
    @Expose
    double mRating;

    @SerializedName("formatted_address")
    @Expose
    String mAddress;


    public void setGeometry(Geometry pLocation) {this.mGeometry = pLocation;}

    public Geometry getGeometry() {
        return mGeometry;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String pIcon) {
        mIcon = pIcon;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setPhotos(List<Photo> photos) {
        mPhotos = photos;
    }

    public List<Photo> getPhotos() {return mPhotos;}

    public String setPlaceId() {
        return mPlaceId;
    }

    public void setPlaceId(String placeId) {
        mPlaceId = placeId;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double perPage) {
        mRating = perPage;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }
}
