package com.example.lovecalculator.fragment;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lovecalculator.App;
import com.example.lovecalculator.data.LoveModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalculationViewModel extends ViewModel {

    String HOST = "love-calculator.p.rapidapi.com";
    String KEY = "0ac5c7f17dmshd67550a69127498p13b2a2jsncbebc809ecfa";

    MutableLiveData<LoveModel> result = new MutableLiveData<>();
    MutableLiveData<String> error = new MutableLiveData<>();
    public LoveModel loveModel = new LoveModel();

    void getLove(String fname, String sname){
        App.api.getLove(fname, sname,HOST, KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                result.postValue(response.body());
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {
                error.postValue(t.getMessage());
            }
        });
    }
}
