package com.thanakorn.weather.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.thanakorn.weather.feature.main.ui.navigation.homeFeatureNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen) {
        homeFeatureNavHost(navController = navController)
    }
}