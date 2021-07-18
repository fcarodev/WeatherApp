package com.portfolio.weatherapp.data.model.user

data class UserModel(
    val rut:String? = null,
    val name:String? = null,
    val lastName:String? = null,
    val email:String? = null,
    val address:Address? = null,
    val password:String? = null,
)

data class Address(
    val address:String?=null,
    val city:String?=null,
    val region:String?=null,
    val country:String?=null
)
