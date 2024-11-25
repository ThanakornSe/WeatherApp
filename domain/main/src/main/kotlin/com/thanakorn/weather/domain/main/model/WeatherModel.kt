package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
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
                icon = this.icon,
                id = this.id,
                main = this.main
            )
    }
}