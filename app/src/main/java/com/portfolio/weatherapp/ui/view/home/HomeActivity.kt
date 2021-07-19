package com.portfolio.weatherapp.ui.view.home

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.portfolio.weatherapp.R
import com.portfolio.weatherapp.data.model.user.UserModel
import com.portfolio.weatherapp.data.model.weather.WeatherModel
import com.portfolio.weatherapp.databinding.ActivityHomeBinding
import com.portfolio.weatherapp.manager.HawkManager
import com.portfolio.weatherapp.ui.view.splash.SplashActivity
import com.portfolio.weatherapp.ui.viewModel.WeatherViewModel
import com.portfolio.weatherapp.utils.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


class HomeActivity : AppCompatActivity(), BottomSheetProfile.ProfileClickListener {
    private lateinit var binding: ActivityHomeBinding
    private val weatherViewModel: WeatherViewModel by viewModels()
    lateinit var clPlaceholder : ConstraintLayout
    var bottomSheetProfileUser = BottomSheetProfile(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home_placeholder)
        clPlaceholder = findViewById(R.id.clHomePlaceholder)
        clPlaceholder.setBackgroundColorByDay(this)
        setStatusBarColor()
        val user = HawkManager().getCurrentUserLoggedIn()
        weatherViewModel.onGetWeatherByCity("${user.address!!.city},${user.address.country}")
        weatherViewModel.weatherModel.observe(this, Observer { weather ->
            Logger.d(Gson().toJson(weather))
            setContentView(binding.root)
            updateView(user, weather)
        })

    }


    private fun updateView(user: UserModel, weather: WeatherModel) {
        val dateTime = LocalDateTime.now()
        binding.imgProfileUser.setOnClickListener {
            bottomSheetProfileUser.show(this.supportFragmentManager, "bottomSheetRegisterUser")
        }
        binding.clHome.setBackgroundColorByDay(this)
        binding.tvCityName.text = user.address!!.city
        binding.tvDate.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
        //animation config
        binding.weatherAnimation.setAnimation(
            WeatherHelper().getWeatherAnimation(
                weather = weather.weather!![0].main
            )
        )
        binding.weatherAnimation.loop(true)
        binding.weatherAnimation.playAnimation()

        //general data
        binding.tvHumidityNumber.text = weather.main!!.humidity
        binding.tvWindNumber.text = weather.wind!!.speed
        binding.tvPressureNumber.text = weather.main.pressure
        //temp
        binding.tvTempNumber.text = "${weather.main.feelsLike}°"
        binding.tvMaxTempNumber.text = "${weather.main.tempMax}°"
        binding.tvMinTempNumber.text = "${weather.main.tempMin}°"
    }

    override fun onLogoutClickListener() {
        HawkManager().deleteCurrentUserLoggedIn()
        navigateToSplash()
    }

    private fun navigateToSplash() {
        val intent = Intent(this, SplashActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        backFromActivityAnimation()
        finish()
    }

}