package com.example.mobileapplication.api;

import com.example.mobileapplication.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickerFetch {
    @GET("services/rest/?method=flicker.photos.getRecent&api_key=2146a6386327a0d18dae60b59b1c5320&extras=url_s&format=json&nojsoncallback=1")
    Call<Example> getRecent();
    @GET("services/rest/?method=flicker.photos.search&api_key=2146a6386327a0d18dae60b59b1c5320&extras=url_s&format=json&nojsoncallback=1")
    Call<Example> getSearchPhotos(@Query("text") String keyWord);
}