package com.portfolio.weatherapp.data.model.user

import com.portfolio.weatherapp.manager.HawkManager

class UserProvider {

    companion object {
        fun isUserExist(userModel: UserModel): UserModel {
            return if (userModel.rut == "1" && userModel.password == "1") {
                UserModel(
                    "18236924-1",
                    "Felipe",
                    "Caro",
                    "felip.caro.vitreras@gmail.com",
                    Address("Av falsa","Villa Alemana","Valparaiso","Chile"),
                    "1234"
                )
            } else {
                UserModel()
            }
        }

        fun userLoggedIn(): UserModel{
            return HawkManager().getCurrentUserLoggedIn()
        }
    }


}