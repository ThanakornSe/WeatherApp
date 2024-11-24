package com.thanakorn.weather.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.closeTask
import com.thanakorn.weather.resource.theme.secondaryText
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.space32Dp
import com.thanakorn.weather.resource.theme.space64Dp
import com.thanakorn.weather.resource.theme.white
import com.thanakorns.todo.resource.R.*

@Composable
fun ErrorScreen(
    onRetryClick: () -> Unit = {},
) {
    Dialog(
        onDismissRequest = {
            onRetryClick.invoke()
        },
        DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(space64Dp)
                .clip(RoundedCornerShape(space32Dp))
                .background(white)
                .padding(space32Dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                modifier = Modifier.size(space64Dp),
                painter = painterResource(drawable.ic_error),
                contentDescription = null,
                tint = closeTask
            )

            Spacer(Modifier.height(space16Dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = secondaryText),
                onClick = {
                    onRetryClick.invoke()
                }
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = space16Dp),
                    text = stringResource(string.error_button_retry),
                    style = Typography.bodyMedium,
                    color = white,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Preview
@Composable
private fun DefaultLoadingScreenPreview() {
    AppTheme {
        ErrorScreen()
    }
}