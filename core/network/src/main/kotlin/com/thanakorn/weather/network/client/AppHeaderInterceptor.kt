package com.thanakorn.weather.network.client

import com.thanakorn.weather.common.Constants
import com.thanakorn.weather.common.base.AppConfiguration
import okhttp3.Interceptor
import okhttp3.Request

fun createHttpHeaderInterceptor(appConfig: AppConfiguration): Interceptor =
    Interceptor {
        it.proceed(
            it.request().newBuilder().headerSetup(appConfig)
        )
    }

fun Request.Builder.headerSetup(appConfig: AppConfiguration): Request {

    appConfig.apiKey?.let { value ->
        header(
            Constants.API_KEY,
            value
        )
    }

    return build()
}