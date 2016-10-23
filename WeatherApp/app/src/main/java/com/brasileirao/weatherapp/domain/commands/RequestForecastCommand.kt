package com.brasileirao.weatherapp.domain.commands

import com.brasileirao.weatherapp.data.ForecastRequest
import com.brasileirao.weatherapp.domain.commands.Command
import com.brasileirao.weatherapp.domain.mappers.ForecastDataMapper
import com.brasileirao.weatherapp.domain.models.ForecastList

/**
 * Created by ueliton on 10/4/16.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val foreCastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecast = foreCastRequest.execute())
    }
}