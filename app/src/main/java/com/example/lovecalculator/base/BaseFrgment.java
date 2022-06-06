package com.example.lovecalculator.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.example.lovecalculator.R;

public abstract class BaseFrgment<VB extends ViewBinding> extends Fragment {

    public abstract VB getLayoutBinding();
    public VB binding;
    protected NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = getLayoutBinding();
        initNavigation();
        return binding.getRoot();
    }

    private void initNavigation(){
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
    }
}
