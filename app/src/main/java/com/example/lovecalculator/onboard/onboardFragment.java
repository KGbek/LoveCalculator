package com.example.lovecalculator.onboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lovecalculator.Pref;
import com.example.lovecalculator.R;
import com.example.lovecalculator.base.BaseFrgment;
import com.example.lovecalculator.databinding.FragmentOnboardBinding;
import com.example.lovecalculator.fragment.CalculatorFragment;

import java.util.List;

import javax.inject.Inject;


public class onboardFragment extends BaseFrgment<FragmentOnboardBinding> {

    TextView[] dots;
    LinearLayout dotsLayout;
    int currentPos;

    @Inject
    Pref pref;


    public FragmentOnboardBinding getLayoutBinding() {
        return FragmentOnboardBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Viewpager2Adapter viewpager2Adapter = new Viewpager2Adapter(requireContext());
        binding.vpMain.setAdapter(viewpager2Adapter);

        binding.vpMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                addDots(position);
                currentPos = position;

                if (position == 0) {
                    binding.startBtn.setVisibility(View.INVISIBLE);
                } else if (position == 1) {
                    binding.startBtn.setVisibility(View.INVISIBLE);
                } else if (position == 2) {
                    binding.startBtn.setVisibility(View.INVISIBLE);
                } else {
                    binding.startBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);

            }
        });
        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref.SaveState();
                navController.navigateUp();
            }
        });
    }

    public void addDots(int pos) {

        dots = new TextView[4];
        binding.Dots.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(requireContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            binding.Dots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[pos].setTextColor(getResources().getColor(R.color.grey));
        }

    }
}