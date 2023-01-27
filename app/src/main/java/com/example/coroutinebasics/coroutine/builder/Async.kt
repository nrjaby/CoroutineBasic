package com.example.coroutinebasics.coroutine.builder

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun getTemperature(): Double {
    // Make the API call and return the temperature
    // return apiCall("https://weather-api.com/current")
    return 40.0
}

 fun getForecast(): List<Double> {
    // Make the API call and return the forecast
    // return apiCall("https://weather-api.com/forecast")
    return listOf(10.0, 20.0, 30.0, 40.0)
}

fun main() {
    runBlocking {
        // Use async to fetch the temperature and forecast concurrently
        val temperature = async { getTemperature() }
        val forecast = async { getForecast() }

        // Use await to wait for the results
        val currentTemp = temperature.await()
        val fiveDayForecast = forecast.await()

        // Print the results
        println("Current temperature: $currentTemp")
        println("Five day forecast: $fiveDayForecast")
    }
}
