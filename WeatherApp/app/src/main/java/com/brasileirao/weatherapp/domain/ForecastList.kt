package com.brasileirao.weatherapp.domain

/**
 * Created by ueliton on 10/4/16.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>) {
}

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)