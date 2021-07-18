package com.portfolio.weatherapp.domain

import com.portfolio.weatherapp.data.WeatherRepository
import com.portfolio.weatherapp.data.model.weather.WeatherModel

class GetWeatherUseCase {
    private val repository = WeatherRepository()

    suspend operator fun invoke(city:String):WeatherModel? = repository.getWeather(city,"es","metric")

}