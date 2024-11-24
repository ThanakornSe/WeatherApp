package com.thanakorn.weather.network.di

import com.google.gson.Gson
import com.thanakorn.weather.common.di.coreCommonModule
import com.thanakorn.weather.network.client.createHttpHeaderInterceptor
import com.thanakorn.weather.network.client.createHttpLoggingInterceptor
import com.thanakorn.weather.network.client.debugInterceptor
import com.thanakorn.weather.network.client.provideOkHttpClient
import org.koin.dsl.module

val networkModule = module {
    includes(coreCommonModule)
    single { Gson() }
    single { createHttpHeaderInterceptor(get()) }
    single { createHttpLoggingInterceptor() }
    single { debugInterceptor(get()) }
    single {
        provideOkHttpClient(
            headerInterceptor = get(),
            loggingInterceptor = get(),
            chuckerInterceptor = get(),
        )
    }
}


