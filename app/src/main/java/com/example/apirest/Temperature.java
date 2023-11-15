package com.example.apirest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Temperature implements Serializable {
    @SerializedName("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }
}