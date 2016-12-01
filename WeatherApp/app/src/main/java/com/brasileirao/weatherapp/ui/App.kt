package com.brasileirao.weatherapp.ui

import android.app.Application
import com.brasileirao.weatherapp.ui.utils.DelegatesExt

/**
 * Created by ueliton.freitas on 10/24/16.
 */
class App : Application(){

    companion object{
        var instance : App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}