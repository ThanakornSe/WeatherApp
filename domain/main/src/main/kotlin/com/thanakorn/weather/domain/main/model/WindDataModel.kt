package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
import com.thanakorn.weather.data.main.model.WindDataResponse

data class WindDataModel(
    @SerializedName("deg")
    val deg: Int? = null,
    @SerializedName("gust")
    val gust: Double? = null,
    @SerializedName("speed")
    val speed: Double? = null,
) {
    companion object {
        fun WindDataResponse.toWindDataModel(): WindDataModel =
            WindDataModel(
                deg = this.deg,
                gust = this.gust,
                speed = this.speed
            )
    }
}