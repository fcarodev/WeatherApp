package com.portfolio.weatherapp.utils

import android.app.Activity
import com.portfolio.weatherapp.R

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