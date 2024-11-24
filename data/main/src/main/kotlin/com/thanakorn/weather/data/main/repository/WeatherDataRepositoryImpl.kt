package com.thanakorn.weather.data.main.repository

import com.thanakorn.weather.common.util.DispatcherProvider
import com.thanakorn.weather.data.main.model.CurrentWeatherResponse
import com.thanakorn.weather.data.main.service.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WeatherDataRepositoryImpl(
    private val service: WeatherService,
    private val dispatcher: DispatcherProvider,
) : WeatherDataRepository {
    override suspend fun getWeatherData(
        cityName: String,
    ): Flow<CurrentWeatherResponse> {
        return flow {
            try {
                val response = service.getWeather(cityName = cityName)
                if (response.isSuccessful) {
                    response.body()?.let { result ->
                        emit(result)
                    }
                }
            } catch (e: Exception) {
                throw e
            }
        }.flowOn(dispatcher.io)
    }
}