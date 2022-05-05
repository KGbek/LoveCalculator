package com.example.lovecalculator;

import android.app.Application;

import com.example.lovecalculator.network.LoveApi;
import com.example.lovecalculator.network.LoveService;

public class App extends Application {

    public static LoveApi api;
    LoveService loveService = new LoveService();

    @Override
    public void onCreate() {
        super.onCreate();
        api = loveService.api;
    }
}
