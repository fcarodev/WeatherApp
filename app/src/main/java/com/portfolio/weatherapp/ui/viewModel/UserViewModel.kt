package com.portfolio.weatherapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portfolio.weatherapp.data.model.user.UserModel
import com.portfolio.weatherapp.data.model.user.UserProvider

class UserViewModel:ViewModel() {


    val userModel  = MutableLiveData<UserModel>()

    fun getUser(user: UserModel){
        val currentUser = UserProvider.isUserExist(user)
        userModel.postValue(currentUser)
    }

    fun getUserLoggedIn(){
        val currentUser = UserProvider.userLoggedIn()
        userModel.postValue(currentUser)
    }
}