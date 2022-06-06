package com.example.lovecalculator;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class Pref {
    SharedPreferences msharedPreferences;

    @Inject
    public Pref(SharedPreferences sharedPreferences) {
        msharedPreferences = sharedPreferences;
    }

    public void SaveState(){
        msharedPreferences.edit().putBoolean("isShown", true).apply();
    }

    public Boolean isBoardShown(){
        return msharedPreferences.getBoolean("isShown", false);
    }
}
