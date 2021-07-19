package com.portfolio.weatherapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portfolio.weatherapp.data.model.user.UserModel
import com.portfolio.weatherapp.data.model.user.UserProvider
import com.portfolio.weatherapp.domain.GetUserLoggedUseCase
import com.portfolio.weatherapp.domain.GetWeatherUseCase

class UserViewModel:ViewModel() {


    val userModel  = MutableLiveData<UserModel>()
    private val getUserLoggedUseCase = GetUserLoggedUseCase()

    fun onLogin(user: UserModel){
        val userLogin = getUserLoggedUseCase(user)
        userModel.postValue(userLogin)
    }

    fun getUserLoggedIn(){
        val currentUser = UserProvider.userLoggedIn()
        userModel.postValue(currentUser)
    }
}