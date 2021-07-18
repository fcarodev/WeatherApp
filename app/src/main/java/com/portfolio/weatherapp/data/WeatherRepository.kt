package com.portfolio.weatherapp.data

import com.portfolio.weatherapp.data.model.weather.WeatherModel
import com.portfolio.weatherapp.data.model.weather.WeatherProvider
import com.portfolio.weatherapp.data.network.WeatherApiClient
import com.portfolio.weatherapp.data.network.WeatherService

class WeatherRepository {
    private val api = WeatherService()

    suspend fun getWeather(city:String,lang:String,units:String):WeatherModel {
        val response = api.getWeather(city,lang,units)
        WeatherProvider.weather = response
        return response
    }
}