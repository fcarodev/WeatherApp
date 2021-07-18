package com.portfolio.weatherapp.ui.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.portfolio.weatherapp.BuildConfig
import com.portfolio.weatherapp.databinding.ActivityLoginBinding
import com.portfolio.weatherapp.data.model.user.UserModel
import com.portfolio.weatherapp.ui.view.home.HomeActivity
import com.portfolio.weatherapp.utils.goToActivityAnimation
import com.portfolio.weatherapp.ui.viewModel.UserViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private val userViewModel : UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvVersionName.text = "v${BuildConfig.VERSION_NAME}"
        binding.btnEnterLogin.setOnClickListener {
            userViewModel.getUser(UserModel(binding.etRutLogin.text.toString(),null,null,null,null,binding.etPassword.text.toString()))
        }

        userViewModel.userModel.observe(this, Observer { user ->
            if (user.rut != null){
                navigateHome()
            }else{
                showErrorMessage()
            }
        })


    }

    private fun showErrorMessage() {
        Toast.makeText(this,"Usuario o contrasena invalidos.",Toast.LENGTH_LONG).show()
    }

    private fun navigateHome() {
        val intent = Intent(this, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        goToActivityAnimation()
        finish()
    }
}