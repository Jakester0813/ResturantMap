package com.jakester.resturantmap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryItem {
    @SerializedName("id")
    @Expose
    String mId;

    @SerializedName("owner")
    @Expose
    String mOwner;

    @SerializedName("secret")
    @Expose
    String mSecret;

    @SerializedName("server")
    @Expose
    String mServer;

    @SerializedName("title")
    @Expose
    String mTitle;

    @SerializedName("url_s")
    @Expose
    String mUrl;

    public String toString(){
        return mTitle;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public String getSecret() {
        return mSecret;
    }

    public void setSecret(String secret) {
        mSecret = secret;
    }

    public String getServer() {
        return mServer;
    }

    public void setServer(String server) {
        mServer = server;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
