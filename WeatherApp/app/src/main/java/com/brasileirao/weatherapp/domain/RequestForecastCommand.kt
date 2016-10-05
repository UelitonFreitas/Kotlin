package com.brasileirao.weatherapp.domain

import com.brasileirao.weatherapp.data.ForecastRequest

/**
 * Created by ueliton on 10/4/16.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val foreCastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecast = foreCastRequest.execute())
    }
}