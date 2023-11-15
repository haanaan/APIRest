package com.example.apirest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class City implements Serializable {
    @SerializedName("city")
    private double city;

    public double getCity() {
        return city;
    }
}
