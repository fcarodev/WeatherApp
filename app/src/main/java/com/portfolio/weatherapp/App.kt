package com.portfolio.weatherapp

import android.app.Application
import com.orhanobut.hawk.Hawk
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Hawk.init(this).build()
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()

            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}