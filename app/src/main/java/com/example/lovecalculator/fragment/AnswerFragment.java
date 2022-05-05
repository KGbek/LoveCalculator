package com.example.lovecalculator.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovecalculator.R;
import com.example.lovecalculator.base.BaseFrgment;
import com.example.lovecalculator.databinding.FragmentAnswerBinding;


public class AnswerFragment extends BaseFrgment<FragmentAnswerBinding> {


    @Override
    public FragmentAnswerBinding getLayoutBinding() {
        return FragmentAnswerBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle answer = getArguments();
        answer.putAll(answer.getBundle(a));
    }
}