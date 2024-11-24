package com.thanakorn.weather.common.util

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
fun String.encodeBase64ForUrl(): String = Base64.UrlSafe.encode(this.toByteArray())

@OptIn(ExperimentalEncodingApi::class)
fun String.decodeBase64ForUrl(): String = String(Base64.UrlSafe.decode(this))

@OptIn(ExperimentalEncodingApi::class)
fun String.encodeBase64(): String = Base64.encode(this.toByteArray())

@OptIn(ExperimentalEncodingApi::class)
fun String.decodeBase64(): String = String(Base64.decode(this))

@OptIn(ExperimentalEncodingApi::class)
fun String.decodeJwtToken(): String {
    val parts = this.split(".")
    return try {
        val charset = charset("UTF-8")
        val header = String(Base64.decode(parts[0].toByteArray(charset)), charset)
        val payload = String(Base64.decode(parts[1].toByteArray(charset)), charset)
        "$header"
        "$payload"
    } catch (e: Exception) {
        "Error parsing JWT: $e"
    }
}
