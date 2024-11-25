package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
import com.thanakorn.weather.data.main.model.CoordResponse

data class CoordModel(
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lon")
    val lon: Double? = null,
) {
    companion object {
        fun CoordResponse.toCoordModel(): CoordModel =
            CoordModel(
                lat = this.lat,
                lon = this.lon
            )
    }
}