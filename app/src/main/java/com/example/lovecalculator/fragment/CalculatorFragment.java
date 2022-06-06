package com.example.lovecalculator.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lovecalculator.R;
import com.example.lovecalculator.base.BaseFrgment;
import com.example.lovecalculator.data.LoveModel;
import com.example.lovecalculator.databinding.FragmentCalculatorBinding;
import com.example.lovecalculator.viewModel.CalculationViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CalculatorFragment extends BaseFrgment<FragmentCalculatorBinding> {

    String firstName;
    String secondName;

    NavController navController;

    CalculationViewModel calculationViewModel;


    @Override
    public FragmentCalculatorBinding getLayoutBinding() {
        return FragmentCalculatorBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calculationViewModel = ViewModelProviders.of(this).get(CalculationViewModel.class);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        binding.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = binding.firstName.getText().toString();
                secondName = binding.secondName.getText().toString();
                calculationViewModel.getLiveDataLoveModel(firstName, secondName).observe(getViewLifecycleOwner(), loveModel -> {
                    Log.e("ololo", "onClick: " + loveModel);
                });
            }
        });

    }
}