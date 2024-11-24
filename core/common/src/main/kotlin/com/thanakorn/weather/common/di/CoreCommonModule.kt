package com.thanakorn.weather.common.di

import com.thanakorn.weather.common.AppConfig
import com.thanakorn.weather.common.base.AppConfiguration
import com.thanakorn.weather.common.util.DefaultDispatchers
import com.thanakorn.weather.common.util.DispatcherProvider
import org.koin.dsl.module

val coreCommonModule = module {
    single<AppConfiguration> { AppConfig }
    single<DispatcherProvider> { DefaultDispatchers() }
}