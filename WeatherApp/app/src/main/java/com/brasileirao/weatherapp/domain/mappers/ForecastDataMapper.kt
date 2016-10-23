package com.brasileirao.weatherapp.domain.mappers

import com.brasileirao.weatherapp.data.Forecast
import com.brasileirao.weatherapp.domain.models.Forecast as ModelForecast
import com.brasileirao.weatherapp.data.ForecastResult
import com.brasileirao.weatherapp.domain.models.ForecastList
import java.text.DateFormat
import java.util.*

/**
 * Created by ueliton on 10/4/16.
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<com.brasileirao.weatherapp.domain.models.Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): com.brasileirao.weatherapp.domain.models.Forecast {
        return com.brasileirao.weatherapp.domain.models.Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String {
        return "http://openweathermap.org/img/w/$iconCode.png"
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 100)
    }
}