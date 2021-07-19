package com.portfolio.weatherapp.domain

import com.portfolio.weatherapp.data.model.user.UserModel
import com.portfolio.weatherapp.data.model.user.UserProvider

class GetUserLoggedUseCase {

    operator fun invoke(userModel: UserModel):UserModel{
        val userModelSaved = UserProvider.userSaved()
        return if(userModel.rut == "1" && userModel.password == "1"){
            userModelSaved
        }else{
            UserModel()
        }
    }
}