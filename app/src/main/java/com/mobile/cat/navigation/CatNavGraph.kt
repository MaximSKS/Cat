package com.mobile.cat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mobile.cat.ui.screens.WikipediaScreen
import com.mobile.cat.ui.screens.details.CatDetailsScreen
import com.mobile.cat.ui.screens.favorites.CatFavoritesScreen
import com.mobile.cat.ui.screens.main.CatHomeScreen
import com.mobile.cat.ui.screens.settings.CatSettingsScreen

@Composable
fun CatNavGraph(
    navHostController: NavHostController,
    onThemeChange: (Boolean) -> Unit
) {

    NavHost(
        navController = navHostController,
        startDestination = CatRoutes.HOME
    ) {

        composable(CatRoutes.HOME) {
            CatHomeScreen(navHostController = navHostController)
        }

        composable(CatRoutes.FAVORITES) {
            CatFavoritesScreen()
        }

        composable(CatRoutes.SETTINGS) {
                CatSettingsScreen(onThemeChange = onThemeChange)
        }

        composable(CatRoutes.DETAILS) {
            CatDetailsScreen(navHostController = navHostController)

        }

        composable(CatRoutes.WIKIPEDIA) {
            WikipediaScreen(navHostController = navHostController)
        }


    }

}