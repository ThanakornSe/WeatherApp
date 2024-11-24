package com.thanakorn.weather.data.main.service

import com.thanakorn.weather.common.Constants.WEATHER_PATH
import com.thanakorn.weather.data.main.model.CurrentWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET(WEATHER_PATH)
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("units") units: String = "metric",
    ): Response<CurrentWeatherResponse>
}