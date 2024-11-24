package com.thanakorn.weather.data.main.di

import com.thanakorn.weather.common.di.coreCommonModule
import com.thanakorn.weather.data.main.repository.WeatherDataRepository
import com.thanakorn.weather.data.main.repository.WeatherDataRepositoryImpl
import com.thanakorn.weather.data.main.service.WeatherService
import com.thanakorn.weather.network.di.retrofitModule
import org.koin.dsl.module
import retrofit2.Retrofit

val mainDataModule = module {
    includes(retrofitModule, coreCommonModule)
    factory { provideWeatherService(get()) }
    single<WeatherDataRepository> { WeatherDataRepositoryImpl(get(),get()) }

}

private fun provideWeatherService(retrofit: Retrofit): WeatherService = retrofit.create(
    WeatherService::class.java
)
