package com.example.lovecalculator.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.lovecalculator.data.LoveModel;
import com.example.lovecalculator.network.LoveApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoveRepository {

    String HOST = "love-calculator.p.rapidapi.com";
    String KEY = "0ac5c7f17dmshd67550a69127498p13b2a2jsncbebc809ecfa";

    LoveApi mapi;

    public LoveRepository(LoveApi api) {
        mapi = api;
    }

    public MutableLiveData<LoveModel> getLove(String firstName, String secondName){
        MutableLiveData<LoveModel> loveModelMutableLiveData = new MutableLiveData<>();

        mapi.getLove(firstName, secondName, HOST, KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                loveModelMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {

            }
        });
        return loveModelMutableLiveData;
    }


}
