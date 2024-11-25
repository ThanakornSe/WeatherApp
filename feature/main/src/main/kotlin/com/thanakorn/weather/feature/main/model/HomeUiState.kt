package com.thanakorn.weather.feature.main.model

import com.thanakorn.weather.domain.main.model.CurrentWeatherModel
import com.thanakorn.weather.feature.main.model.CloudsUiState.Companion.toCloudsUiState
import com.thanakorn.weather.feature.main.model.CoordUiState.Companion.toCoordUiState
import com.thanakorn.weather.feature.main.model.MainDataUiState.Companion.toMainDataUiState
import com.thanakorn.weather.feature.main.model.SysDataUiState.Companion.toSysDataUiState
import com.thanakorn.weather.feature.main.model.WeatherUiState.Companion.toWeatherUiState
import com.thanakorn.weather.feature.main.model.WindDataUiState.Companion.toWindDataUiState

data class HomeUiState(
    val clouds: CloudsUiState? = null,
    val coord: CoordUiState? = null,
    val id: Int? = null,
    val main: MainDataUiState? = null,
    val name: String? = null,
    val sys: SysDataUiState? = null,
    val timezone: Int? = null,
    val visibility: Int? = null,
    val weather: List<WeatherUiState>? = null,
    val wind: WindDataUiState? = null,
) {
    companion object {
        fun CurrentWeatherModel.toHomeUiState(): HomeUiState =
            HomeUiState(
                clouds = this.clouds?.toCloudsUiState(),
                coord = this.coord?.toCoordUiState(),
                id = this.id,
                main = this.main?.toMainDataUiState(),
                name = this.name,
                sys = this.sys?.toSysDataUiState(),
                timezone = this.timezone,
                visibility = this.visibility,
                weather = this.weather?.map { it.toWeatherUiState() },
                wind = this.wind?.toWindDataUiState()
            )
    }
}
