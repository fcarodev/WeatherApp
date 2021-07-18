package com.portfolio.weatherapp.data.network

import com.portfolio.weatherapp.data.model.weather.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {

    @GET("data/2.5/weather?")
    suspend fun getWeather(@Query("q") query: String, @Query("appid") key:String, @Query("lang") lang:String,@Query("units") units:String): Response<WeatherModel>

}


