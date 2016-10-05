package com.brasileirao.weatherapp.data

import com.google.gson.Gson
import java.net.URL

/**
 * Created by ueliton on 10/4/16.
 */
class ForecastRequest(val zipCode: String){

    companion object{
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val BASE_URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$BASE_URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult{
        val forecastJsonStr = URL(COMPLETE_URL+zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}