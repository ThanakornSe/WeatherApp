package com.thanakorn.weather.data.main.model


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("clouds")
    val cloudsResponse: CloudsResponse? = null,
    @SerializedName("cod")
    val cod: Int? = null,
    @SerializedName("coord")
    val coord: CoordResponse? = null,
    @SerializedName("dt")
    val dt: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("main")
    val main: MainDataResponse? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("sys")
    val sys: SysDataResponse? = null,
    @SerializedName("timezone")
    val timezone: Int? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("weather")
    val weatherResponse: List<WeatherResponse>? = null,
    @SerializedName("wind")
    val wind: WindDataResponse? = null
)