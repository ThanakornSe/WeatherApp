package com.thanakorn.weather.feature.main.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thanakorn.weather.feature.main.model.HomeUiState
import com.thanakorn.weather.resource.R
import com.thanakorn.weather.resource.R.drawable
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.backgroundInfoColor
import com.thanakorn.weather.resource.theme.borderColor
import com.thanakorn.weather.resource.theme.space150Dp
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.space1Dp
import com.thanakorn.weather.resource.theme.white

@Composable
fun WeatherInfo(uiState: HomeUiState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(space16Dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        uiState.name?.let {
            Text(
                modifier = Modifier.padding(bottom = space16Dp),
                text = it,
                color = white,
                style = Typography.titleLarge
            )
        }
        uiState.weather?.firstOrNull()?.let {
            Text(
                modifier = Modifier.padding(bottom = space16Dp),
                text = it.description ?: "",
                color = white,
                style = Typography.titleMedium
            )
            AsyncImage(
                modifier = Modifier
                    .size(space150Dp)
                    .padding(bottom = space16Dp),
                model = it.icon,
                contentDescription = null
            )
        }
        uiState.main?.let {
            Text(
                modifier = Modifier.padding(bottom = space16Dp),
                text = stringResource(R.string.temp_value, it.temp.toString()),
                color = white,
                style = Typography.titleLarge,
                fontSize = 63.sp
            )
            Text(
                modifier = Modifier.padding(bottom = space16Dp),
                text = stringResource(
                    R.string.temp_max_temp_low,
                    it.tempMax.toString(),
                    it.tempMin.toString()
                ),
                color = white,
                style = Typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(space16Dp))
                .border(
                    width = space1Dp,
                    color = borderColor,
                    shape = RoundedCornerShape(space16Dp)
                )
                .background(backgroundInfoColor)
                .padding(
                    space16Dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            uiState.clouds?.all?.let {
                TempInfoDetail(
                    painterResource(drawable.cloudy) , value = stringResource(
                        R.string.all_cloud,
                        it.toString()
                    )
                )
            }
            uiState.wind?.speed?.let {
                TempInfoDetail(
                    painterResource(drawable.wind), value = stringResource(
                        R.string.wind_speed
                    ).format(it.toString())
                )
            }
            uiState.main?.humidity?.let {
                TempInfoDetail(
                    painterResource(drawable.humidity), value = stringResource(
                        R.string.humidity
                    ).format(it.toString())
                )
            }
        }
    }

}


@Composable
@Preview
private fun DefaultWeatherInfoPreview() {
    AppTheme { WeatherInfo(HomeUiState()) }
}