package com.thanakorn.weather.domain.main.di

import com.thanakorn.weather.data.main.di.mainDataModule
import org.koin.dsl.module

val mainDomainModule = module {
    includes(mainDataModule)
}