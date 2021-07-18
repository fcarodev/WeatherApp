package com.portfolio.weatherapp.ui.view.home

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.portfolio.weatherapp.R
import com.portfolio.weatherapp.ui.viewModel.WeatherViewModel

class HomeActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by   viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = Color.parseColor("#060720")

        weatherViewModel.onCreate("Villa alemana, Chile")


        weatherViewModel.weatherModel.observe(this, Observer { weather->
            Logger.d(Gson().toJson(weather))
        })
    }
}