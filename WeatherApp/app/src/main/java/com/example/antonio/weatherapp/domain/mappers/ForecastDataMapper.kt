package com.example.antonio.weatherapp.domain.mappers

import com.example.antonio.weatherapp.data.Forecast
import com.example.antonio.weatherapp.data.ForecastResult
import com.example.antonio.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.example.antonio.weatherapp.domain.model.Forecast as ModelForecast

/**
 * Created by antonio on 22/05/17.
 */

class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}