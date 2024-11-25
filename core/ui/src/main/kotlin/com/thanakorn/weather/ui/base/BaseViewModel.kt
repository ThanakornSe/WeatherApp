package com.thanakorn.weather.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel<T> : ViewModel() {

    protected val _uiState = MutableStateFlow(BaseUiState<T>())
    open val uiState: StateFlow<BaseUiState<T>> get() = _uiState.asStateFlow()

    fun setLoading(isLoading: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = isLoading,
            )
        }
    }

    fun setApiError(isApiError: Boolean, errorMessage: String? = null) {
        _uiState.update { currentState ->
            currentState.copy(
                mainUiState = null,
                isApiError = isApiError,
                errorMessage = errorMessage,
            )
        }
    }

}
