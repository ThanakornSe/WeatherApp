package com.thanakorn.weather.common.base

interface AppConfiguration {
    var isDebug: Boolean
    var baseApiUrl: String?
    var apiKey: String?
}