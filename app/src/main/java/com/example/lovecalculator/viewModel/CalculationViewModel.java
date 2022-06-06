package com.example.lovecalculator.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lovecalculator.data.LoveModel;
import com.example.lovecalculator.repository.LoveRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CalculationViewModel extends ViewModel {

    LoveRepository mloveRepository;

    @Inject
    public CalculationViewModel(LoveRepository loveRepository) {
        mloveRepository = loveRepository;
    }

    public MutableLiveData<LoveModel> getLiveDataLoveModel(String first, String second){
        return mloveRepository.getLove(first, second);
    }
}
