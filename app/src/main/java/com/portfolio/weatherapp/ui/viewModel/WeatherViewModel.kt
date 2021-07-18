package com.portfolio.weatherapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portfolio.weatherapp.data.model.weather.WeatherModel
import com.portfolio.weatherapp.domain.GetWeatherUseCase
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

     val weatherModel = MutableLiveData<WeatherModel>()
    private val getWeatherUseCase = GetWeatherUseCase()

    fun onCreate(city:String) {
       viewModelScope.launch {
           val result = getWeatherUseCase.invoke(city)
           weatherModel.postValue(result!!)
       }
    }
}