package com.example.quynh.resources1.data.book;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TNYTimeService {
    @GET("?api-key=b8dcacb453d04ace85cc9a330c06f45d")
    Call<NewYorkTime> getKey();
    @GET("overview.json?api-key=b8dcacb453d04ace85cc9a330c06f45d")
    Call<NewYorkTime> getKeyOverView();
    @GET("names.json?api-key=b8dcacb453d04ace85cc9a330c06f45d")
    Call<NewYorkTime> getKeyNames();
}
