package com.thanakorn.weather.ui.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.thanakorn.weather.ui.compose.LoadingScreen

@Composable
fun <T> BaseViewModelCommonActionCompose(
    viewModel: BaseViewModel<T>,
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        LoadingScreen()
    }

}
