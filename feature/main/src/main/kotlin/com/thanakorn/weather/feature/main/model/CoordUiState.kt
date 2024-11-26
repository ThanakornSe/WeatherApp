package com.thanakorn.weather.feature.main.model


import com.thanakorn.weather.domain.main.model.CoordModel

data class CoordUiState(
    val lat: Double? = null,
    val lon: Double? = null,
) {
    companion object {
        fun CoordModel.toCoordUiState(): CoordUiState =
            CoordUiState(
                lat = this.lat,
                lon = this.lon
            )
    }
}