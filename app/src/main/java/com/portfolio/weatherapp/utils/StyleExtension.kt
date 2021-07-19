package com.portfolio.weatherapp.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.portfolio.weatherapp.R
import okhttp3.internal.toLongOrDefault
import java.util.*

internal fun Activity.goToActivityAnimation() {
    overridePendingTransition(
        R.anim.slide_in_right,
        R.anim.slide_out_left
    )
}
internal fun Activity.backFromActivityAnimation() {
    overridePendingTransition(
        R.anim.slide_in_left,
        R.anim.slide_out_right
    )
}

fun AppCompatActivity.setStatusBarColor(){
    val rightNow = Calendar.getInstance()
    val currentHourIn24Format = rightNow[Calendar.HOUR_OF_DAY] //from 0-23
    if((0..6).contains(currentHourIn24Format)){
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorClearNight)
        return
    }
    if((7..10).contains(currentHourIn24Format)){
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorEarlyMorning)
        return
    }
    if((11..20).contains(currentHourIn24Format)){
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorMorning)
        return
    }
    if((21..24).contains(currentHourIn24Format)){
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorClearNight)
        return
    }
}
fun String.getWeather():WeatherConstants{
    when(this){
        "Rain"->{
            return WeatherConstants.RAIN
        }
        "Clear"->{
            return WeatherConstants.CLEAR

        }
        "Snow"->{
            return WeatherConstants.SNOW

        }
        "Extreme"->{
            return WeatherConstants.EXTREME
        }
        else-> return  WeatherConstants.CLEAR
     }
}

fun ConstraintLayout.setBackgroundColorByDay(context: Context){
    val rightNow = Calendar.getInstance()
    val currentHourIn24Format = rightNow[Calendar.HOUR_OF_DAY]
    if ((0..6).contains(currentHourIn24Format)) {
        this.setBackgroundColor(ContextCompat.getColor(context, R.color.colorClearNight))
        return
    }
    if ((7..10).contains(currentHourIn24Format)) {
        this.setBackgroundColor(ContextCompat.getColor(context, R.color.colorEarlyMorning))
        return
    }
    if ((11..20).contains(currentHourIn24Format)) {
        this.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMorning))
        return
    }
    if ((21..24).contains(currentHourIn24Format)) {
        this.setBackgroundColor(ContextCompat.getColor(context, R.color.colorClearNight))
        return
    }
}