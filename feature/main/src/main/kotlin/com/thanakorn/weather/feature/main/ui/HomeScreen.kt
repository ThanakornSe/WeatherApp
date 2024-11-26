package com.thanakorn.weather.feature.main.ui

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.thanakorn.weather.feature.main.model.HomeUiState
import com.thanakorn.weather.feature.main.ui.compose.WelcomeScreen
import com.thanakorn.weather.feature.main.ui.compose.WeatherInfo
import com.thanakorn.weather.feature.main.ui.compose.WeatherInfoLargeScreen
import com.thanakorn.weather.feature.main.viewmodel.HomeViewModel
import com.thanakorn.weather.resource.R.drawable
import com.thanakorn.weather.resource.R.string
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.backgroundEndColor
import com.thanakorn.weather.resource.theme.backgroundStartColor
import com.thanakorn.weather.resource.theme.space150Dp
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.white
import com.thanakorn.weather.ui.base.BaseUiState
import com.thanakorn.weather.ui.base.BaseViewModelCommonActionCompose
import com.thanakorn.weather.ui.compose.ErrorScreen
import com.thanakorn.weather.ui.compose.WindowInfo
import com.thanakorn.weather.ui.compose.gradientBackground
import com.thanakorn.weather.ui.compose.rememberWindowInfo
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeMainScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BaseViewModelCommonActionCompose(viewModel = viewModel)

    HomeScreen(
        uiState = uiState,
        onSearchClick = { cityName ->
            viewModel.getCurrentWeather(cityName)
        },
        onErrorScreenClick = {
            viewModel.setApiError(isApiError = false, errorMessage = null)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit = {},
    onErrorScreenClick: () -> Unit = {},
    uiState: BaseUiState<HomeUiState>,
) {
    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val windowInfo = rememberWindowInfo()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .gradientBackground(listOf(backgroundStartColor, backgroundEndColor))
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(string.app_name),
                    style = Typography.titleLarge,
                    color = white,
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = space16Dp),
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    text = stringResource(string.search_text_field),
                    color = white,
                    style = Typography.bodyMedium
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        onSearchClick(text)
                    }
                ) {
                    Icon(
                        painter = painterResource(drawable.ic_search),
                        contentDescription = null,
                        tint = white
                    )
                }
            },
            singleLine = true,
            textStyle = Typography.bodyLarge,
            shape = RoundedCornerShape(space16Dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = white,
                unfocusedTextColor = white,
                focusedBorderColor = white,
                unfocusedBorderColor = white,
                cursorColor = white,
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    onSearchClick(text)
                },
            )
        )

        if (uiState.isApiError) {
            Spacer(modifier = Modifier.weight(0.7f))
            ErrorScreen(
                errorMessage = uiState.errorMessage,
                onRetryClick = {
                    onErrorScreenClick()
                    text = ""
                }
            )
        } else {
            uiState.mainUiState?.let {
                Spacer(modifier = Modifier.height(space16Dp))
                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
                    WeatherInfo(uiState = it)
                } else {
                    WeatherInfoLargeScreen(uiState = it)
                }
            } ?: run {
                Spacer(modifier = Modifier.weight(0.7f))
                WelcomeScreen()
            }
        }
        Spacer(Modifier.weight(1f))
    }
}

@Composable
@Preview(showBackground = true)
private fun DefaultHomeScreenPreview() {
    AppTheme {
        HomeScreen(uiState = BaseUiState(mainUiState = null))
    }
}