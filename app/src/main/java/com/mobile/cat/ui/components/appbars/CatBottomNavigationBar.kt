package com.mobile.cat.ui.components.appbars

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mobile.cat.navigation.CatBottomNavigationItem
import com.mobile.cat.ui.theme.primaryOrange


/** @composable fun [CatBottomNavigationBar] creates bottom navigation bar with icons (items) on it */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CatBottomNavigationBar(
    navController: NavController,
    ) {

    val navItems = listOf(
        CatBottomNavigationItem.Home,
        CatBottomNavigationItem.Favorites,
        CatBottomNavigationItem.Settings,
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val bottomBarRoute = navItems.any { it.route == currentRoute }

    if (bottomBarRoute) {

        NavigationBar(
            modifier = Modifier.height(65.dp),
            containerColor = MaterialTheme.colorScheme.background,

        ) {

            navItems.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                    },
                    icon = {

                        Icon(
                            painter =
                            if (currentRoute == item.route) {
                                painterResource(id = item.selectedIcon)
                            } else painterResource(id = item.unselectedIcon),
                            contentDescription = "Bottom bar icon",
                            tint = primaryOrange

                        )

                    },
                    label = {
                        Text(
                            text = stringResource(id = item.title),
                            color = primaryOrange
                        )
                    },

                    colors = NavigationBarItemDefaults.colors(primaryOrange)
                )

            }

        }
    }

}