package com.mobile.cat.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mobile.cat.navigation.CatNavGraph
import com.mobile.cat.ui.components.appbars.CatBottomNavigationBar


@Composable
fun CatMainScreenTest(onThemeChange: (Boolean) -> Unit) {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {
            CatBottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues),
        ) {
            CatNavGraph(navHostController = navController, onThemeChange = onThemeChange)
        }

    }
}