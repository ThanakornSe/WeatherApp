package com.thanakorn.weather.data.main.model


import com.google.gson.annotations.SerializedName

data class SysDataResponse(
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("sunrise")
    val sunrise: Int? = null,
    @SerializedName("sunset")
    val sunset: Int? = null,
    @SerializedName("type")
    val type: Int? = null
)