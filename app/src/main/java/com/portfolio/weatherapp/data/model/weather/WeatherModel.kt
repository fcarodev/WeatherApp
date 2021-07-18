package com.portfolio.weatherapp.data.model.weather

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("coord")
    val coord: Coord? = null,

    @SerializedName("weather")
    val weather: MutableList<Weather>? = null,

    @SerializedName("base")
    val base: String? = null,

    @SerializedName("main")
    val main: Main? = null,

    @SerializedName("wind")
    val wind: Wind? = null
)

data class Coord(
    val lon: String,
    val lat: String
)

data class Weather(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    @SerializedName("temp")
    val temp: String,

    @SerializedName("feels_like")
    val feelsLike: String,

    @SerializedName("temp_min")
    val tempMin: String,

    @SerializedName("temp_max")
    val tempMax: String,

    @SerializedName("pressure")
    val pressure: String,

    @SerializedName("humidity")
    val humidity: String
)

data class Wind(
    val speed: String,
    val deg: String
)
