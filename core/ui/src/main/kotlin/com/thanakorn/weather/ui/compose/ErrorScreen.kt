package com.thanakorn.weather.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.thanakorn.weather.resource.R.drawable
import com.thanakorn.weather.resource.R.string
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.refresh
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.space2Dp
import com.thanakorn.weather.resource.theme.space64Dp
import com.thanakorn.weather.resource.theme.white

@Composable
fun ErrorScreen(
    errorMessage: String? = null,
    onRetryClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .padding(space16Dp), contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier
                    .size(space64Dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(drawable.ic_data_error),
                contentDescription = null,
                tint = white
            )
            Spacer(Modifier.height(space16Dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = errorMessage ?: "",
                style = Typography.titleMedium,
                color = white,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp
            )
            Spacer(Modifier.height(space16Dp))
            OutlinedButton(
                modifier = Modifier,
                onClick = onRetryClick,
                border = BorderStroke(width = space2Dp, color = refresh)
            ) {
                Icon(
                    painter = painterResource(drawable.ic_refresh),
                    contentDescription = null,
                    tint = refresh
                )
                Spacer(Modifier.width(space16Dp))
                Text(
                    text = stringResource(string.error_screen_try_again),
                    style = Typography.titleMedium,
                    color = refresh,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview
@Composable
private fun DefaultLoadingScreenPreview() {
    AppTheme {
        ErrorScreen(
            errorMessage = "Could not find a city"
        )
    }
}