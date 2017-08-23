package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jake on 8/23/2017.
 */

    public class Result {

        @SerializedName("formatted_address")
        @Expose
        private String formattedAddress;
        @SerializedName("formatted_phone_number")
        @Expose
        private String formattedPhoneNumber;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("photos")
        @Expose
        private List<Photo> photos;
        @SerializedName("rating")
        @Expose
        private Double rating;
        @SerializedName("reference")
        @Expose
        private String reference;
        @SerializedName("reviews")
        @Expose
        private List<Review> reviews = null;

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public String getFormattedPhoneNumber() {
            return formattedPhoneNumber;
        }

        public void setFormattedPhoneNumber(String formattedPhoneNumber) {
            this.formattedPhoneNumber = formattedPhoneNumber;
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Photo> getPhoto() {
            return photos;
        }

        public void setPhotos(List<Photo> photo) {
            this.photos = photo;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }



}
