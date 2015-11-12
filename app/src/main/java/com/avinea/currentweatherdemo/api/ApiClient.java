package com.avinea.currentweatherdemo.api;

import com.avinea.currentweatherdemo.model.CurrentWeather;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by joeyespinosa on 11/12/15.
 */
public class ApiClient {

    private static RestAdapter mRestAdapter;
    private static OpenWeatherApiServiceImpl mOpenWeatherApiServiceImpl;
    private static final String API_URL = "http://api.openweathermap.org/data/2.5";
    public static final String API_KEY = "318416689ea54e429b447dd9bf302876";

    public static RestAdapter getRestAdapter() {

        if (mRestAdapter == null) {
            mRestAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .build();
        }

        return mRestAdapter;
    }

    public static OpenWeatherApiServiceImpl getOpenWeatherApiClient() {

        if (mOpenWeatherApiServiceImpl == null) {
            mRestAdapter = getRestAdapter();

            mOpenWeatherApiServiceImpl = mRestAdapter.create(OpenWeatherApiServiceImpl.class);
        }

        return mOpenWeatherApiServiceImpl;
    }

    public interface OpenWeatherApiServiceImpl {

        @GET("/weather")
        void getCityCurrentWeather(@Query("q") String city, @Query("APPID") String appId, Callback<CurrentWeather> callback);
    }
}
