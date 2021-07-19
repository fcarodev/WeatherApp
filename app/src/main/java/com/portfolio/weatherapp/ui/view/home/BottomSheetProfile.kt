package com.portfolio.weatherapp.ui.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.portfolio.weatherapp.R
import com.portfolio.weatherapp.manager.HawkManager
import kotlinx.android.synthetic.main.bottom_sheet_profile.*


class BottomSheetProfile(var itemClickListener: ProfileClickListener) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userLogged = HawkManager().getCurrentUserLoggedIn()
        txtNameUserProfile.text = "${userLogged.name} ${userLogged.lastName}"
        txtRutUserProfile.text = userLogged.rut
        txtMailUserProfile.text = userLogged.email
        txtAddressUserProfile.text = "${userLogged.address!!.city}, ${userLogged.address!!.country}"
        txtLogout.setOnClickListener {
            itemClickListener.onLogoutClickListener()
        }

    }

    interface ProfileClickListener {

        fun onLogoutClickListener()
    }
}