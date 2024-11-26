package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
import com.thanakorn.weather.data.main.model.MainDataResponse

data class MainDataModel(
    @SerializedName("feels_like")
    val feelsLike: Double? = null,
    @SerializedName("grnd_level")
    val grndLevel: Int? = null,
    @SerializedName("humidity")
    val humidity: Int? = null,
    @SerializedName("pressure")
    val pressure: Int? = null,
    @SerializedName("sea_level")
    val seaLevel: Int? = null,
    @SerializedName("temp")
    val temp: Double? = null,
    @SerializedName("temp_max")
    val tempMax: Double? = null,
    @SerializedName("temp_min")
    val tempMin: Double? = null,
) {
    companion object {
        fun MainDataResponse.toMainDataModel(): MainDataModel =
            MainDataModel(
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