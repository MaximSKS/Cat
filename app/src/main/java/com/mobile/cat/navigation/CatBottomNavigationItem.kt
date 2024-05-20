package com.mobile.cat.navigation

import com.mobile.cat.R
import com.mobile.cat.ui.CatIcons

/** @sealed class [CatBottomNavigationItem] for creating items on bottom navigation bar
 * @param [title]  title under the icon
 * @param [selectedIcon]   icon for navigation bar
 * @param [route]  route name constant
 **/

sealed class CatBottomNavigationItem(
    val title: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val route: String,
) {
    object Home : CatBottomNavigationItem(
        title = R.string.nav_home,
        selectedIcon = CatIcons.PawFilled,
        unselectedIcon = CatIcons.PawBorder,
        route = CatRoutes.HOME
    )

    object Favorites : CatBottomNavigationItem(
        title = R.string.nav_favorites,
        selectedIcon = CatIcons.FavoritesFilled,
        unselectedIcon = CatIcons.FavoritesBorder,
        route = CatRoutes.FAVORITES,
    )

    object Settings : CatBottomNavigationItem(
        title = R.string.nav_settings,
        selectedIcon = CatIcons.SettingsFilled,
        unselectedIcon = CatIcons.SettingsBorder,
        route = CatRoutes.SETTINGS
    )
}