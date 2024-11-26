package com.thanakorn.weather.ui.compose

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Modifier.gradientBackground(colors: List<Color>) =
    this.then(
        Modifier
            .background(
                brush = Brush.linearGradient(colors)
            ),
    )
