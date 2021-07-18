package com.portfolio.weatherapp.utils

import com.portfolio.weatherapp.BuildConfig


fun String.encrypt() :String  = ChCrypto.aesEncrypt(this, BuildConfig.CRYPT_KEY)
fun String.decrypt() :String  = ChCrypto.aesDecrypt(this, BuildConfig.CRYPT_KEY)