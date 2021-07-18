package com.portfolio.weatherapp.manager

import com.orhanobut.hawk.Hawk
import com.portfolio.weatherapp.data.model.user.UserModel
import com.portfolio.weatherapp.utils.CURRENT_USER

class HawkManager {

    fun getCurrentUserLoggedIn(): UserModel {
        return if (Hawk.contains(CURRENT_USER)) {
            Hawk.get(CURRENT_USER)
        } else {
            UserModel()
        }
    }

    fun setCurrentUserLoggedIn(user: UserModel) {
        Hawk.put(CURRENT_USER, user)
    }

    fun deleteCurrentUserLoggedIn() {
        if (Hawk.contains(CURRENT_USER)) {
            Hawk.delete(CURRENT_USER)
        }
    }


}
