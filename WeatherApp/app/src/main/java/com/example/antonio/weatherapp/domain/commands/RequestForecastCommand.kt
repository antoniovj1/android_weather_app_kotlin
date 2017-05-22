package com.example.antonio.weatherapp.domain.commands

import com.example.antonio.weatherapp.data.ForecastRequest
import com.example.antonio.weatherapp.domain.mappers.ForecastDataMapper
import com.example.antonio.weatherapp.domain.model.ForecastList

/**
 * Created by antonio on 22/05/17.
 */


class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}