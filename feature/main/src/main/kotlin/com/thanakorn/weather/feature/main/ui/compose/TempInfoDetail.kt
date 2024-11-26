package com.thanakorn.weather.feature.main.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.space48Dp
import com.thanakorn.weather.resource.theme.space8Dp
import com.thanakorn.weather.resource.theme.white

@Composable
fun TempInfoDetail(icon: Painter, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            modifier = Modifier.size(space48Dp).padding(bottom = space8Dp),
            painter = icon,
            contentDescription = null
        )
        Text(
            text = value,
            color = white,
            style = Typography.bodySmall,
            lineHeight = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}