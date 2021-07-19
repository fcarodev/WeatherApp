package com.portfolio.weatherapp.ui.view.splash

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.github.florent37.viewanimator.ViewAnimator
import com.orhanobut.logger.Logger
import com.portfolio.weatherapp.R
import com.portfolio.weatherapp.databinding.ActivityMainBinding
import com.portfolio.weatherapp.ui.view.home.HomeActivity
import com.portfolio.weatherapp.ui.view.login.LoginActivity
import com.portfolio.weatherapp.utils.goToActivityAnimation
import com.portfolio.weatherapp.ui.viewModel.UserViewModel
import com.portfolio.weatherapp.utils.setStatusBarColor

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startAnimation()
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorClearNight)
        Handler().postDelayed({
            isUserLoggedIn()
        }, 1000)

        userViewModel.userModel.observe(this, Observer { user ->
            if (user.rut != null) {
                Logger.i("Is user logged in, go to Home")
                navigateHome()
            } else {
                Logger.i("Is user not logged in, go to Login")
                navigateLogin()
            }
        })
    }

    private fun isUserLoggedIn() {
        userViewModel.getUserLoggedIn()
    }

    private fun startAnimation() {
        Logger.i("Starting animation")
        ViewAnimator
            .animate(binding.lySplash)
            .alpha(0f, 1f)
            .duration(800)
            .start()
    }

    private fun navigateHome() {
        val intent = Intent(this, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        goToActivityAnimation()
        finish()
    }

    private fun navigateLogin() {
        val intent = Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        goToActivityAnimation()
        finish()
    }
}