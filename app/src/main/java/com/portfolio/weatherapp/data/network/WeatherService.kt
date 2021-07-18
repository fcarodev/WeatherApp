package com.portfolio.weatherapp.data.network

import com.portfolio.weatherapp.BuildConfig
import com.portfolio.weatherapp.core.RestClient
import com.portfolio.weatherapp.data.model.weather.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherService {
    private val retrofit = RestClient.getRetrofit()

    suspend fun getWeather(city:String,lang:String,units:String):WeatherModel {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(WeatherApiClient::class.java).getWeather(city,BuildConfig.WEATHER_KEY,lang,units)
            response.body() ?: WeatherModel()
        }
    }
}