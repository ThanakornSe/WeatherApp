package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
import com.thanakorn.weather.data.main.model.SysDataResponse

data class SysDataModel(
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("sunrise")
    val sunrise: Int? = null,
    @SerializedName("sunset")
    val sunset: Int? = null,
    @SerializedName("type")
    val type: Int? = null,
) {
    companion object {
        fun SysDataResponse.toSysDataModel(): SysDataModel =
            SysDataModel(
                country = this.country,
                id = this.id,
                sunrise = this.sunrise,
                sunset = this.sunset,
                type = this.type
            )
    }
}