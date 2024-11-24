package com.thanakorn.weather.ui.base

data class BaseUiState<T>(
    val mainUiState: T? = null,
    val isApiError: Boolean = false,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
)
