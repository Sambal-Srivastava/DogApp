package com.app.dogapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.dogapp.presentation.screens.CachedImagesScreen
import com.app.dogapp.presentation.screens.GenerateDogsScreen
import com.app.dogapp.presentation.screens.HomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home) {
        composable<Screen.Home> {
            HomeScreen(navController)
        }
        composable<Screen.GenerateDogs> {
            GenerateDogsScreen(navController)
        }
        composable<Screen.CachedImages> {
            CachedImagesScreen(navController)
        }
    }
}