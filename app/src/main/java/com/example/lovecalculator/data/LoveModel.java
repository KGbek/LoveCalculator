package com.example.lovecalculator.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoveModel implements Serializable {

    @SerializedName("fname")
    String firstName;
    @SerializedName("sname")
    String secondName;
    String percentage;
    String result;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
