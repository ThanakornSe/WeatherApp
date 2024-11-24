package com.thanakorn.weather.application

import android.app.Application
import com.thanakorn.weather.BuildConfig
import com.thanakorn.weather.common.base.AppConfiguration
import com.thanakorn.weather.di.appModule
import com.thanakorn.weather.feature.main.di.mainFeatureModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class WeatherApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        setupAppConfig()
        setupTimber()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@WeatherApplication)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(appModule)
        }
    }

    private fun setupAppConfig() {
        val appConfig: AppConfiguration = get()
        appConfig.apply {
            isDebug = BuildConfig.DEBUG
            baseApiUrl = BuildConfig.PREFIX
            apiKey = BuildConfig.API_KEY
        }
    }

    private fun setupTimber() {
        val appConfig: AppConfiguration = get()
        if (appConfig.isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}