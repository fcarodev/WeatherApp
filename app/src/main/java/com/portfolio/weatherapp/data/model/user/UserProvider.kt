package com.portfolio.weatherapp.data.model.user

import com.portfolio.weatherapp.manager.HawkManager

class UserProvider {

    companion object {
        fun userSaved(): UserModel {
            return UserModel(
                "18236665-1",
                "Marcelo",
                "Contreras",
                "mcontreras@gmail.com",
                Address("Av falsa", "Calama", "Valparaiso", "Chile"),
                "1234"
            )
        }

        fun userLoggedIn(): UserModel {
            return HawkManager().getCurrentUserLoggedIn()
        }
    }

}