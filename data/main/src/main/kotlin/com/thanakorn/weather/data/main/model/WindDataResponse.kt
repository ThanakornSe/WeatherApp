package com.thanakorn.weather.data.main.model


import com.google.gson.annotations.SerializedName

data class WindDataResponse(
    @SerializedName("deg")
    val deg: Int? = null,
    @SerializedName("gust")
    val gust: Double? = null,
    @SerializedName("speed")
    val speed: Double? = null
)