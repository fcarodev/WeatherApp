package com.portfolio.weatherapp.data.model.user

import com.portfolio.weatherapp.manager.HawkManager

class UserProvider {

    companion object {
        fun userSaved(): UserModel {
            return UserModel(
                "18236924-1",
                "Felipe",
                "Caro",
                "felip.caro.vitreras@gmail.com",
                Address("Av falsa", "Villa Alemana", "Valparaiso", "Chile"),
                "1234"
            )
        }

        fun userLoggedIn(): UserModel {
            return HawkManager().getCurrentUserLoggedIn()
        }
    }


}