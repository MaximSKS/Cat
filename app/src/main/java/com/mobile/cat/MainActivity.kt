package com.mobile.cat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.mobile.cat.data.local.ThemePreferencesDataStore
import com.mobile.cat.presentation.screens.home.CatLaunchScreen
import com.mobile.cat.ui.theme.CatTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        lifecycleScope.launch {
             ThemePreferencesDataStore.isDarkTheme(this@MainActivity).collect { isDarkTheme ->

                setContent {

                    var currentTheme by rememberSaveable { mutableStateOf(isDarkTheme) }

                    CatTheme(darkTheme = currentTheme) {

                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            CatLaunchScreen(
                                onThemeChange = { newTheme ->
                                    lifecycleScope.launch {
                                        ThemePreferencesDataStore.setDarkTheme(
                                            this@MainActivity,
                                            newTheme
                                        )
                                    }
                                    currentTheme = newTheme
                                }
                            )

                        }
                    }
                }
            }
        }
    }
}