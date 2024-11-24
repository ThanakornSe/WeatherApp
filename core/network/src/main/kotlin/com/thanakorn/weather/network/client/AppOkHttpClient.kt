package com.thanakorn.weather.network.client

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import com.thanakorn.weather.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit

private const val BASE_TIME_OUT = 30L
private const val CHUCKER_LENGTH_LIMIT = 250000L
private const val HTTP_LOG_MAX_LENGTH = 3950

fun provideOkHttpClient(
    headerInterceptor: Interceptor,
    loggingInterceptor: HttpLoggingInterceptor,
    chuckerInterceptor: ChuckerInterceptor,
): OkHttpClient {
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val okHttpClientBuilder =
        OkHttpClient
            .Builder()
            .readTimeout(BASE_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(BASE_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(BASE_TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
    if (BuildConfig.DEBUG) {
        okHttpClientBuilder.addInterceptor(chuckerInterceptor)
    }
    return okHttpClientBuilder.build()
}

fun createHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor { message ->
        val newLogMessage = if (message.startsWith("{") || message.startsWith("[")) {
            try {
                GsonBuilder().setPrettyPrinting()
                    .create().toJson(JsonParser.parseString(message))
            } catch (m: JsonSyntaxException) {
                message
            }
        } else {
            message
        }
        val logMaxLength = HTTP_LOG_MAX_LENGTH
        val messageLength = newLogMessage.length
        if (messageLength > logMaxLength) {
            var x = 0
            while (x < messageLength) {
                if (x + logMaxLength < messageLength) {
                    Timber.d(newLogMessage.substring(x, x + logMaxLength))
                } else {
                    Timber.d(newLogMessage.substring(x, messageLength))
                }
                x += logMaxLength
            }
        } else {
            Timber.d(newLogMessage)
        }
    }.apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

fun debugInterceptor(context: Context): ChuckerInterceptor =
    ChuckerInterceptor
        .Builder(context)
        .collector(debugCollector(context))
        .maxContentLength(CHUCKER_LENGTH_LIMIT)
        .redactHeaders(emptySet())
        .alwaysReadResponseBody(true)
        .build()

fun debugCollector(context: Context) =
    ChuckerCollector(
        context = context,
        showNotification = true,
        retentionPeriod = RetentionManager.Period.ONE_HOUR,
    )