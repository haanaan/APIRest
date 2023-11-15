package com.example.apirest;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherServices {
    @GET("weather?q=Annecy&units=metric&appid=e075a0b59517e88cc46940bb262add13")
    Call<Forecast> getForcast();

    @GET("weather?units=metric&lang=fr&appid=e075a0b59517e88cc46940bb262add13")
    Call<Forecast> getForecastByCity( @Query("q") String city);

}
