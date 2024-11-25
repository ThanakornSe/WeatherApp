package com.thanakorn.weather.feature.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.thanakorn.weather.common.util.DispatcherProvider
import com.thanakorn.weather.domain.main.usecase.GetCurrentWeatherUseCase
import com.thanakorn.weather.feature.main.model.HomeUiState
import com.thanakorn.weather.feature.main.model.HomeUiState.Companion.toHomeUiState
import com.thanakorn.weather.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: GetCurrentWeatherUseCase,
    private val dispatcher: DispatcherProvider,
) : BaseViewModel<HomeUiState>() {

    fun getCurrentWeather(cityName: String) {
        viewModelScope.launch {
            useCase.execute(cityName)
                .flowOn(dispatcher.io)
                .onStart { setLoading(true) }
                .onEach { setLoading(false) }
                .catch { throwable ->
                    setApiError(isApiError = true, errorMessage = throwable.message)
                }
                .map { currentWeather ->
                    currentWeather.toHomeUiState()
                }
                .collectLatest { homeUiStates ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            mainUiState = homeUiStates
                        )
                    }
                }
        }
    }
}