package com.example.weatherapp.Retrofit;

import com.example.weatherapp.WeatherModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIService {

    //    base url : - https://api.weatherapi.com/
    @GET("v1/forecast")
    Call<List<WeatherModel>> get(@QueryMap Map<String, String> param);
}
