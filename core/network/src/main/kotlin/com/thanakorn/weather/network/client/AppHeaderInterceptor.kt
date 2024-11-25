package com.thanakorn.weather.network.client

import com.thanakorn.weather.common.Constants
import com.thanakorn.weather.common.base.AppConfiguration
import okhttp3.Interceptor
import okhttp3.Request

fun createHttpHeaderInterceptor(appConfig: AppConfiguration): Interceptor =
    Interceptor { chain ->
        val newUrl = chain.request().url.newBuilder()
            .addQueryParameter(Constants.API_KEY, appConfig.apiKey)
            .build()
        chain.proceed(chain.request().newBuilder().url(newUrl).build())
    }