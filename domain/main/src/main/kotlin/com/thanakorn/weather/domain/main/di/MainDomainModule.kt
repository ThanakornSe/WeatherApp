package com.thanakorn.weather.domain.main.di

import com.thanakorn.weather.data.main.di.mainDataModule
import com.thanakorn.weather.domain.main.usecase.GetCurrentWeatherUseCase
import org.koin.dsl.module

val mainDomainModule = module {
    includes(mainDataModule)
    single { GetCurrentWeatherUseCase(get()) }
}