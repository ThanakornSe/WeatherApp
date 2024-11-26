package com.thanakorn.weather.feature.main.model


import com.thanakorn.weather.domain.main.model.MainDataModel

data class MainDataUiState(
    val feelsLike: Double? = null,
    val grndLevel: Int? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,
    val seaLevel: Int? = null,
    val temp: Double? = null,
    val tempMax: Double? = null,
    val tempMin: Double? = null,
) {
    companion object {
        fun MainDataModel.toMainDataUiState(): MainDataUiState =
            MainDataUiState(
                feelsLike = this.feelsLike,
                grndLevel = this.grndLevel,
                humidity = this.humidity,
                pressure = this.pressure,
                seaLevel = this.seaLevel,
                temp = this.temp,
                tempMax = this.tempMax,
                tempMin = this.tempMin
            )
    }
}