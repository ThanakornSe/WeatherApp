package com.thanakorn.weather.feature.main.ui.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.thanakorn.weather.resource.R.drawable
import com.thanakorn.weather.resource.R.string
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.space150Dp
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.white
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen() {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideIn(tween(500, easing = LinearOutSlowInEasing)) { fullSize ->
            IntOffset(fullSize.width / 4, 100)
        },
    ) {
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

}

@Composable
@Preview
private fun DefaultWelcomeScreenPreview() {
    AppTheme {
        WelcomeScreen()
    }
}