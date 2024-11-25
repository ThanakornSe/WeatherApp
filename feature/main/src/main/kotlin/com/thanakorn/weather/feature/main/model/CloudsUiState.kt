package com.thanakorn.weather.feature.main.model


import com.thanakorn.weather.domain.main.model.CloudsModel

data class CloudsUiState(
    val all: Int? = null,
) {
    companion object {
        fun CloudsModel.toCloudsUiState(): CloudsUiState =
            CloudsUiState(
                all = this.all
            )
    }
}