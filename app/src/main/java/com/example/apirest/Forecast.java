package com.example.apirest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Forecast implements Serializable {

    @SerializedName("dt")
    private int datetime;

    @SerializedName("name")
    private String city;

    @SerializedName("main")
    private Temperature temperature;

    @SerializedName("weather")
    private Weather[] conditions;

    public Temperature getTemperature() {
        return temperature;
    }

    public String getCity() {
        return city;
    }

    public Weather[] getConditions() {return conditions;}
}
