package com.example.quynh.resources1.data.main;

import com.example.quynh.resources1.data.book.NewYorkTime;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MainService {
    @GET("articlesearch.json?begin_date=20160112&sort=oldest&fq=news_desk:(%22Education%22%20%22Health%22)&api-key=227c750bb7714fc39ef1559ef1bd8329")
    Call<Main> gettestKey();

    @GET("articlesearch.json")
    Call<Main> gettestQuery(@Query("begin_date") String q,
                            @Query("page") Integer page,
                            @Query("sort") String sort,
                            @Query("fq") String fq,
                            @Query("api-key") String key);


    @PATCH("api-key=227c750bb7714fc39ef1559ef1bd8329")
    Call<Main> getkey();
}
