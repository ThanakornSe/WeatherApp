package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
import com.thanakorn.weather.common.Constants
import com.thanakorn.weather.data.main.model.WeatherResponse

data class WeatherModel(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("icon")
    val icon: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("main")
    val main: String? = null,
) {
    companion object {
        fun WeatherResponse.toWeatherModel(): WeatherModel =
            WeatherModel(
                description = this.description,
                icon = Constants.WEATHER_ICON_PATH + this.icon + Constants.WEATHER_ICON_SIZE_PATH,
                id = this.id,
                main = this.main
            )
    }
}