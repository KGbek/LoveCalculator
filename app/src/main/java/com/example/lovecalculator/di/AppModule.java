package com.example.lovecalculator.di;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.lovecalculator.network.LoveApi;
import com.example.lovecalculator.repository.LoveRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public class AppModule {

    SharedPreferences sharedPreferences;

    @Provides
    @Singleton
    public LoveApi provideLoveApi(){
        return new Retrofit.Builder()
                .baseUrl("https://love-calculator.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(LoveApi.class);
    }

    @Provides
    public SharedPreferences provideSharedPref(@NonNull @ApplicationContext Context context){
        return context.getSharedPreferences("isShow", Context.MODE_PRIVATE);
    }

    @Provides
    public LoveRepository provideLoveRepository(){
        return new LoveRepository(provideLoveApi());
    }
}
