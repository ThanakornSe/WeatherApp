package com.thanakorn.weather.feature.main.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.thanakorn.weather.feature.main.model.CloudsUiState
import com.thanakorn.weather.feature.main.model.CoordUiState
import com.thanakorn.weather.feature.main.model.HomeUiState
import com.thanakorn.weather.feature.main.model.MainDataUiState
import com.thanakorn.weather.feature.main.model.SysDataUiState
import com.thanakorn.weather.feature.main.model.WeatherUiState
import com.thanakorn.weather.feature.main.model.WindDataUiState
import com.thanakorn.weather.resource.R
import com.thanakorn.weather.resource.theme.AppTheme
import com.thanakorn.weather.resource.theme.Typography
import com.thanakorn.weather.resource.theme.backgroundInfoColor
import com.thanakorn.weather.resource.theme.borderColor
import com.thanakorn.weather.resource.theme.space16Dp
import com.thanakorn.weather.resource.theme.space250Dp
import com.thanakorn.weather.resource.theme.space2Dp
import com.thanakorn.weather.resource.theme.space32Dp
import com.thanakorn.weather.resource.theme.white

@Composable
fun WeatherInfoLargeScreen(uiState: HomeUiState) {
    Column(
        modifier = Modifier
            .padding(space16Dp)
            .clip(RoundedCornerShape(space32Dp))
            .background(backgroundInfoColor)
            .border(width = space2Dp, color = borderColor, shape = RoundedCornerShape(space32Dp))
            .padding(space16Dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            uiState.weather?.firstOrNull()?.let {
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .size(space250Dp),
                    model = it.icon,
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    error = {
                        if (LocalInspectionMode.current) {
                            Icon(painter = painterResource(R.drawable.ic_weather), contentDescription = null, tint = white)
                        }
                    }
                )

            }
            Column {
                uiState.name?.let {
                    Text(
                        modifier = Modifier.padding(bottom = space16Dp),
                        text = it,
                        color = white,
                        style = Typography.titleLarge
                    )
                }
                uiState.weather?.firstOrNull()?.description?.let {
                    Text(
                        modifier = Modifier.padding(bottom = space16Dp),
                        text = it,
                        color = white,
                        style = Typography.titleMedium
                    )
                }
                uiState.main?.let {
                    Text(
                        modifier = Modifier.padding(bottom = space16Dp),
                        text = stringResource(R.string.temp_value, it.temp.toString()),
                        color = white,
                        style = Typography.titleLarge,
                        fontSize = 63.sp,
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
            }

        }
        Spacer(Modifier.height(space16Dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            uiState.clouds?.all?.let {
                TempInfoDetail(
                    painterResource(R.drawable.cloudy), value = stringResource(
                        R.string.all_cloud,
                        it.toString()
                    )
                )
            }
            uiState.wind?.speed?.let {
                TempInfoDetail(
                    painterResource(R.drawable.wind), value = stringResource(
                        R.string.wind_speed
                    ).format(it.toString())
                )
            }
            uiState.main?.humidity?.let {
                TempInfoDetail(
                    painterResource(R.drawable.humidity), value = stringResource(
                        R.string.humidity
                    ).format(it.toString())
                )
            }
        }
    }
}


@Composable
@Preview(device = Devices.FOLDABLE)
private fun DefaultWeatherInfoLargeScreenPreview() {
    AppTheme {
        WeatherInfoLargeScreen(
            HomeUiState(
                clouds = CloudsUiState(all = 90),
                coord = CoordUiState(lat = null, lon = null),
                cod = 100,
                id = 1,
                main = MainDataUiState(
                    feelsLike = 20.00,
                    grndLevel = 1000,
                    humidity = 80,
                    pressure = 80,
                    seaLevel = 80,
                    temp = 30.00,
                    tempMax = 35.00,
                    tempMin = 30.00
                ),
                name = "Bangkok",
                sys = SysDataUiState(
                    country = "TH",
                    id = 888,
                    sunrise = null,
                    sunset = null,
                    type = null
                ),
                timezone = 7,
                visibility = 1000,
                weather = listOf(
                    WeatherUiState(
                        description = "Over cloud",
                        icon = "10a",
                        id = 0,
                        main = "Test"
                    )
                ),
                wind = WindDataUiState(deg = null, gust = null, speed = 32.00)
            )
        )
    }
}