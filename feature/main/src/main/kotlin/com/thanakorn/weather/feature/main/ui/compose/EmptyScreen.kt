package com.thanakorn.weather.feature.main.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.white

@Composable
fun EmptyScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(space16Dp), contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Please Enter City's Name to get Weather",
            style = Typography.titleLarge,
            color = white,
            textAlign = TextAlign.Center,
            lineHeight = 36.sp
        )
    }
}

@Composable
@Preview
private fun DefaultEmptyScreenPreview() {
    AppTheme {
        EmptyScreen()
    }
}