package com.thanakorn.weather.feature.main.di

import com.thanakorn.weather.common.di.coreCommonModule
import com.thanakorn.weather.domain.main.di.mainDomainModule
import com.thanakorn.weather.feature.main.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainFeatureModule = module {
    includes(mainDomainModule, coreCommonModule)
    viewModelOf(::HomeViewModel)
}