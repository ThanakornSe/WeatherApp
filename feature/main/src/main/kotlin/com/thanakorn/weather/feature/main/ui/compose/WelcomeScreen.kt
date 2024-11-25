package com.thanakorn.weather.feature.main.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.thanakorn.weather.resource.R.*
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.space150Dp
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.white

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = space16Dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(space150Dp),
            painter = painterResource(drawable.ic_weather),
            contentDescription = null,
            tint = white
        )
        Spacer(Modifier.height(space16Dp))
        Text(
            text = stringResource(string.empty_screen_txt),
            style = Typography.titleMedium,
            color = white,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
private fun DefaultWelcomeScreenPreview() {
    AppTheme {
        WelcomeScreen()
    }
}