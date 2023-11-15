package com.example.apirest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("description")
    private String conditions;

    public String getConditions() {
        return conditions;
    }

}
