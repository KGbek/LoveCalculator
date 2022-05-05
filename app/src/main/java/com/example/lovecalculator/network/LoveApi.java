package com.example.lovecalculator.network;

import com.example.lovecalculator.data.LoveModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LoveApi {

    @GET("getPercentage")
    Call<LoveModel> getLove(
            @Query("fname") String firstName,
            @Query("sname") String secondName,
            @Header("X-RapidAPI-Host") String hostHeader,
            @Header("X-RapidAPI-Key") String headerKey);
}
