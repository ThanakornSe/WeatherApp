package com.thanakorn.weather.domain.main.model


import com.google.gson.annotations.SerializedName
import com.thanakorn.weather.data.main.model.CloudsResponse

data class CloudsModel(
    @SerializedName("all")
    val all: Int? = null,
) {
    companion object {
        fun CloudsResponse.toCloudModel(): CloudsModel =
            CloudsModel(
                all = this.all
            )
    }
}