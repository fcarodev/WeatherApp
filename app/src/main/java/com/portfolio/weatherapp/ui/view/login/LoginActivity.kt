package com.portfolio.weatherapp.ui.view.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.orhanobut.logger.Logger
import com.portfolio.weatherapp.BuildConfig
import com.portfolio.weatherapp.R
import com.portfolio.weatherapp.databinding.ActivityLoginBinding
import com.portfolio.weatherapp.data.model.user.UserModel
import com.portfolio.weatherapp.manager.HawkManager
import com.portfolio.weatherapp.ui.view.home.HomeActivity
import com.portfolio.weatherapp.utils.goToActivityAnimation
import com.portfolio.weatherapp.ui.viewModel.UserViewModel
import com.portfolio.weatherapp.utils.setStatusBarColor

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorClearNight)
        binding.tvVersionName.text = "v${BuildConfig.VERSION_NAME}"
        binding.btnEnterLogin.setOnClickListener {
            Logger.i("User press login button")
            userViewModel.onLogin(
                UserModel(
                    binding.etRutLogin.text.toString(),
                    null,
                    null,
                    null,
                    null,
                    binding.etPassword.text.toString()
                )
            )
        }

        userViewModel.userModel.observe(this, Observer { user ->
            if (user.rut != null) {
                Logger.i("Success login")
                HawkManager().setCurrentUserLoggedIn(user)
                navigateHome()
            } else {
                Logger.i("Failed login")
                showErrorMessage()
            }
        })

    }

    private fun showErrorMessage() {
        Toast.makeText(this, "Usuario o contrasena invalidos.", Toast.LENGTH_LONG).show()
    }

    private fun navigateHome() {
        val intent = Intent(this, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        goToActivityAnimation()
        finish()
    }
}