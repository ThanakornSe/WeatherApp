package com.thanakorn.weather.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.space64Dp
import com.thanakorn.weather.resource.theme.statusBar
import com.thanakorn.weather.resource.theme.white

@Composable
fun LoadingScreen() {
    Dialog(
        onDismissRequest = { },
        DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false,
        ),
    ) {
        Box(
            contentAlignment = Center,
            modifier = Modifier.background(Transparent),
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(space64Dp),
                color = statusBar,
                trackColor = white,
            )
        }
    }
}

@Preview
@Composable
private fun DefaultLoadingScreenPreview() {
    AppTheme {
        LoadingScreen()
    }
}