package com.thanakorn.weather.di

import com.thanakorn.weather.common.di.coreCommonModule
import com.thanakorn.weather.feature.main.di.mainFeatureModule
import org.koin.dsl.module

val appModule = module {
    includes(
        mainFeatureModule,
        coreCommonModule
    )
}