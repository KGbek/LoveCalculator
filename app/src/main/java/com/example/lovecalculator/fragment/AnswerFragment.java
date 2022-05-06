package com.example.lovecalculator.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lovecalculator.base.BaseFrgment;
import com.example.lovecalculator.data.LoveModel;
import com.example.lovecalculator.databinding.FragmentAnswerBinding;


public class AnswerFragment extends BaseFrgment<FragmentAnswerBinding> {


    @Override
    public FragmentAnswerBinding getLayoutBinding() {
        return FragmentAnswerBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoveModel loveResult = (LoveModel) getArguments().getSerializable("response");
        binding.firstName.setText(loveResult.getFirstName().toString());
        binding.secondName.setText(loveResult.getSecondName().toString());
        binding.percentge.setText("Percentage is : "+loveResult.getPercentage().toString());
        binding.result.setText(loveResult.getResult().toString());
    }
}