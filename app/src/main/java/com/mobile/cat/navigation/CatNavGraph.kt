package com.mobile.cat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mobile.cat.presentation.screens.details.CatDetailsScreen
import com.mobile.cat.presentation.screens.favorites.CatFavoritesScreen
import com.mobile.cat.presentation.screens.home.CatHomeScreen
import com.mobile.cat.presentation.screens.settings.CatSettingsScreen

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

        composable(
            route = "${CatRoutes.DETAILS}/{catImage}/{breedName}/{weight}/{lifeSpan}/{origin}/{adaptability}/{hypoallergenic}/{temperament}/{childFriendly}/{dogFriendly}/{strangerFriendly}/{sheddingLevel}/{affectionLevel}/{socialNeeds}/{energyLevel}/{intelligence}/{description}/{wikipediaUrl}",
            arguments = listOf(
                navArgument("catImage") { type = NavType.StringType },
                navArgument("breedName") { type = NavType.StringType },
                navArgument("weight") { type = NavType.StringType },
                navArgument("lifeSpan") { type = NavType.StringType },
                navArgument("origin") { type = NavType.StringType },
                navArgument("adaptability") { type = NavType.IntType },
                navArgument("hypoallergenic") { type = NavType.IntType },
                navArgument("temperament") { type = NavType.StringType },
                navArgument("childFriendly") { type = NavType.IntType },
                navArgument("dogFriendly") { type = NavType.IntType },
                navArgument("strangerFriendly") { type = NavType.IntType },
                navArgument("sheddingLevel") { type = NavType.IntType },
                navArgument("affectionLevel") { type = NavType.IntType },
                navArgument("socialNeeds") { type = NavType.IntType },
                navArgument("energyLevel") { type = NavType.IntType },
                navArgument("intelligence") { type = NavType.IntType },
                navArgument("description") { type = NavType.StringType },
                navArgument("wikipediaUrl") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val catImage = backStackEntry.arguments?.getString("catImage") ?: ""
            val breedName = backStackEntry.arguments?.getString("breedName") ?: "Unknown"
            val weight = backStackEntry.arguments?.getString("weight") ?: "Unknown"
            val lifeSpan = backStackEntry.arguments?.getString("lifeSpan") ?: "Unknown"
            val origin = backStackEntry.arguments?.getString("origin") ?: "Unknown"
            val temperament = backStackEntry.arguments?.getString("temperament") ?: "Unknown"
            val adaptability = backStackEntry.arguments?.getInt("adaptability") ?: 0
            val hypoallergenic = backStackEntry.arguments?.getInt("hypoallergenic") ?: 0
            val childFriendly = backStackEntry.arguments?.getInt("childFriendly") ?: 0
            val dogFriendly = backStackEntry.arguments?.getInt("dogFriendly") ?: 0
            val strangerFriendly = backStackEntry.arguments?.getInt("strangerFriendly") ?: 0
            val sheddingLevel = backStackEntry.arguments?.getInt("sheddingLevel") ?: 0
            val affectionLevel = backStackEntry.arguments?.getInt("affectionLevel") ?: 0
            val socialNeeds = backStackEntry.arguments?.getInt("socialNeeds") ?: 0
            val energyLevel = backStackEntry.arguments?.getInt("energyLevel") ?: 0
            val intelligence = backStackEntry.arguments?.getInt("intelligence") ?: 0
            val description = backStackEntry.arguments?.getString("description") ?: "Unknown"
            val wikipediaUrl = backStackEntry.arguments?.getString("wikipediaUrl") ?: "Page not found"

            CatDetailsScreen(
                navHostController = navHostController,
                catImage = catImage,
                breedName = breedName,
                weight = weight,
                lifeSpan = lifeSpan,
                origin = origin,
                adaptability = adaptability,
                temperament = temperament,
                childFriendly = childFriendly,
                dogFriendly = dogFriendly,
                strangerFriendly = strangerFriendly,
                sheddingLevel = sheddingLevel,
                affectionLevel = affectionLevel,
                socialNeeds = socialNeeds,
                energyLevel = energyLevel,
                intelligence = intelligence,
                description = description,
                hypoallergenic = hypoallergenic,
                wikipediaUrl = wikipediaUrl,
            )
        }


    }

}