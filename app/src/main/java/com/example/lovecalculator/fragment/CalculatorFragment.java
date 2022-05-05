package com.example.lovecalculator.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.Toast;

import com.example.lovecalculator.App;
import com.example.lovecalculator.base.BaseFrgment;
import com.example.lovecalculator.data.LoveModel;
import com.example.lovecalculator.databinding.FragmentCalculatorBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalculatorFragment extends BaseFrgment<FragmentCalculatorBinding> {

    String HOST = "love-calculator.p.rapidapi.com";
    String KEY = "0ac5c7f17dmshd67550a69127498p13b2a2jsncbebc809ecfa";

    String firstName;
    String secondName;

    @Override
    public FragmentCalculatorBinding getLayoutBinding() {
        return FragmentCalculatorBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = binding.firstName.getText().toString();
                secondName = binding.secondName.getText().toString();
                App.api.getLove(firstName, secondName, HOST, KEY).enqueue(new Callback<LoveModel>() {
                    @Override
                    public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                        if (response.isSuccessful()){
                            Intent args = new Intent();
                            Bundle bundleArgs = new Bundle();
                            bundleArgs.putString("fname", firstName.toString());
                            bundleArgs.putString("sname", secondName.toString());
                            args.putExtra("bundles", bundleArgs);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoveModel> call, Throwable t) {
                        Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}