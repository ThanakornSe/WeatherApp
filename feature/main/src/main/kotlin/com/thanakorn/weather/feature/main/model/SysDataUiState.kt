package com.thanakorn.weather.feature.main.model


import com.thanakorn.weather.domain.main.model.SysDataModel

data class SysDataUiState(
    val country: String? = null,
    val id: Int? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
    val type: Int? = null,
) {
    companion object {
        fun SysDataModel.toSysDataUiState(): SysDataUiState =
            SysDataUiState(
                country = this.country,
                id = this.id,
                sunrise = this.sunrise,
                sunset = this.sunset,
                type = this.type
            )
    }
}