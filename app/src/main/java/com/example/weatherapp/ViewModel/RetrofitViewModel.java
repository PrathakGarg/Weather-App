package com.example.weatherapp.ViewModel;

import android.app.Application;

import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.Retrofit.APIService;
import com.example.weatherapp.Retrofit.RetrofitInstance;
import com.example.weatherapp.WeatherModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitViewModel extends AndroidViewModel {

    private MutableLiveData<List<WeatherModel>> weatherList;

    public RetrofitViewModel(@Nullable Application application) {
        super(application);
        weatherList = new MutableLiveData<>();
    }

    public MutableLiveData<List<WeatherModel>> getWeatherList() {
        return weatherList;

    }


    public void makeApiCall(String cityName) {
        APIService apiService = RetrofitInstance.getRetroClient().create(APIService.class);
        Map<String, String> data = new HashMap<>();
        data.put("key", "cf08f776e9d64f458ba151049222502");
        data.put("q", cityName);
        data.put("days", "1");
        Call<List<WeatherModel>> call = apiService.get(data);
        call.enqueue(new Callback<List<WeatherModel>>() {
            @Override
            public void onResponse(Call<List<WeatherModel>> call, Response<List<WeatherModel>> response) {
                weatherList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<WeatherModel>> call, Throwable t) {

            }
        });
    }

}
