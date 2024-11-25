package com.thanakorn.weather.domain.main.usecase

import com.thanakorn.weather.data.main.repository.WeatherDataRepository
import com.thanakorn.weather.domain.main.model.CurrentWeatherModel
import com.thanakorn.weather.domain.main.model.CurrentWeatherModel.Companion.toCurrentWeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCurrentWeatherUseCase(private val repository: WeatherDataRepository) {
    suspend fun execute(cityName: String): Flow<CurrentWeatherModel> =
        repository.getWeatherData(cityName).map { response ->
            response.toCurrentWeatherModel()
        }
}