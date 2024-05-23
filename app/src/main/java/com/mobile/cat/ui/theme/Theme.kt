package com.mobile.cat.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalCatTypography = staticCompositionLocalOf { CatTypography() }
val LocalCatShapes = staticCompositionLocalOf { CatShapes }


val LightDefaultColorScheme = lightColorScheme(
    background = primaryWhite,
    primary = primaryOrange,
    onPrimary = orange65
)

val DarkDefaultColorScheme = darkColorScheme(
    background = primaryGray,
    primary = primaryOrange,
    onPrimary = orange65
)

@Composable
fun CatTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit = {},

) {

    val colorScheme = when {
        darkTheme -> DarkDefaultColorScheme
        else -> LightDefaultColorScheme
    }

    val typography = CatTypography()
    val shapes = CatShapes

    CompositionLocalProvider(
        LocalCatTypography provides typography,
        LocalCatShapes provides shapes
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            shapes = CatShapes,
            content = content,
        )
    }
}