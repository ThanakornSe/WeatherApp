package com.thanakorn.weather.feature.main.model


import com.thanakorn.weather.domain.main.model.WindDataModel

data class WindDataUiState(
    val deg: Int? = null,
    val gust: Double? = null,
    val speed: Double? = null,
) {
    companion object {
        fun WindDataModel.toWindDataUiState(): WindDataUiState =
            WindDataUiState(
                deg = this.deg,
                gust = this.gust,
                speed = this.speed
            )
    }
}