package com.thanakorn.weather.feature.main.model


import com.thanakorn.weather.domain.main.model.WeatherModel

data class WeatherUiState(
    val description: String? = null,
    val icon: String? = null,
    val id: Int? = null,
    val main: String? = null,
) {
    companion object {
        fun WeatherModel.toWeatherUiState(): WeatherUiState =
            WeatherUiState(
                description = this.description,
                icon = this.icon,
                id = this.id,
                main = this.main
            )
    }
}