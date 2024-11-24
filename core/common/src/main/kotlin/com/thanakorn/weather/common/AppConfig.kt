package com.thanakorn.weather.common

import com.thanakorn.weather.common.base.AppConfiguration

object AppConfig : AppConfiguration {
    override var isDebug: Boolean = false
    override var baseApiUrl: String? = null
    override var apiKey: String? = null
}