package com.thanakorn.weather.data.main.repository

import com.thanakorn.weather.data.main.model.CurrentWeatherResponse
import kotlinx.coroutines.flow.Flow

interface WeatherDataRepository {
    suspend fun getWeatherData(cityName: String): Flow<CurrentWeatherResponse>
}