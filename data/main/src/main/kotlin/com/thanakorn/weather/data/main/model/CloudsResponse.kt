package com.thanakorn.weather.data.main.model


import com.google.gson.annotations.SerializedName

data class CloudsResponse(
    @SerializedName("all")
    val all: Int? = null
)