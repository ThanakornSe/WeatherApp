package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
import com.thanakorn.weather.data.main.model.CurrentWeatherResponse
import com.thanakorn.weather.domain.main.model.CloudsModel.Companion.toCloudModel
import com.thanakorn.weather.domain.main.model.CoordModel.Companion.toCoordModel
import com.thanakorn.weather.domain.main.model.MainDataModel.Companion.toMainDataModel
import com.thanakorn.weather.domain.main.model.SysDataModel.Companion.toSysDataModel
import com.thanakorn.weather.domain.main.model.WeatherModel.Companion.toWeatherModel
import com.thanakorn.weather.domain.main.model.WindDataModel.Companion.toWindDataModel

data class CurrentWeatherModel(
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("clouds")
    val cloudsResponse: CloudsModel? = null,
    @SerializedName("cod")
    val cod: Int? = null,
    @SerializedName("coord")
    val coord: CoordModel? = null,
    @SerializedName("dt")
    val dt: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("main")
    val main: MainDataModel? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("sys")
    val sys: SysDataModel? = null,
    @SerializedName("timezone")
    val timezone: Int? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("weather")
    val weatherResponse: List<WeatherModel>? = null,
    @SerializedName("wind")
    val wind: WindDataModel? = null,
) {
    companion object {
        fun CurrentWeatherResponse.toCurrentWeatherModel(): CurrentWeatherModel =
            CurrentWeatherModel(
                base = this.base,
                cloudsResponse = this.cloudsResponse?.toCloudModel(),
                cod = this.cod,
                coord = this.coord?.toCoordModel(),
                dt = this.dt,
                id = this.id,
                main = this.main?.toMainDataModel(),
                name = this.name,
                sys = this.sys?.toSysDataModel(),
                timezone = this.timezone,
                visibility = this.visibility,
                weatherResponse = this.weatherResponse?.map { it.toWeatherModel() },
                wind = this.wind?.toWindDataModel()
            )
    }
}