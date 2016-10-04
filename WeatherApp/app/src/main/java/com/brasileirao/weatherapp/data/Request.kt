package com.brasileirao.weatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by ueliton on 10/3/16.
 */
class Request(val url: String){

    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }

}