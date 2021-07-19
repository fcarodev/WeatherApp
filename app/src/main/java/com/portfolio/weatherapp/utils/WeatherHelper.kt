package com.portfolio.weatherapp.utils

import com.orhanobut.logger.Logger
import java.util.*

class WeatherHelper {



    fun getWeatherAnimation(weather: String): String {

        return when (getWeatherStatus()) {
            WeatherStatus.DAY -> {
                getWeatherDay(weather)
            }
            WeatherStatus.NIGHT -> {
                getWeatherNight(weather)
            }
        }
    }

    private fun getWeatherStatus(): WeatherStatus {
        val rightNow = Calendar.getInstance()
        val currentHourIn24Format = rightNow[Calendar.HOUR_OF_DAY] //from 0-23
        if ((7..20).contains(currentHourIn24Format)){
            return WeatherStatus.DAY
        }
        return WeatherStatus.NIGHT
    }

    private fun getWeatherNight(weather: String): String {
        return when (weather.getWeather()) {
            WeatherConstants.RAIN -> {
                "weather_night_rain.json"
            }
            WeatherConstants.CLEAR -> {
                "weather_night_clear_sky.json"
            }
            WeatherConstants.EXTREME -> {
                "weather_night_thunderstorm.json"
            }
            WeatherConstants.SNOW -> {
                "weather_night_snow.json"
            }
        }
    }

    private fun getWeatherDay(weather: String): String {

        return when (weather.getWeather()) {
            WeatherConstants.RAIN -> {
                "weather_day_rain.json"
            }
            WeatherConstants.CLEAR -> {
                "weather_day_clear_sky.json"
            }
            WeatherConstants.EXTREME -> {
                "weather_day_thunderstorm.json"
            }
            WeatherConstants.SNOW -> {
                "weather_day_snow.json"
            }
        }
    }
}




