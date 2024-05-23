package com.mobile.cat.presentation.screens.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.cat.R
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.components.cards.CatCardSecondary
import com.mobile.cat.ui.theme.LocalCatTypography
import com.mobile.cat.ui.theme.SIZE_10_DP
import com.mobile.cat.ui.theme.SIZE_16_DP
import com.mobile.cat.ui.theme.SIZE_1_DP
import com.mobile.cat.ui.theme.SIZE_4_DP
import com.mobile.cat.ui.theme.primaryOrange
import com.mobile.cat.ui.theme.secondaryOrange


@Composable
fun CatSettingsScreen(onThemeChange: (Boolean) -> Unit) {

    val lightThemeName = stringResource(id = R.string.light_theme)
    val darkThemeName = stringResource(id = R.string.dark_theme)

    val themeNameList = listOf(lightThemeName, darkThemeName)

    var isDarkTheme by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        themeNameList.forEach { themeName ->
            CatCardSecondary(
                modifier = Modifier
                    .padding(start = SIZE_16_DP, top = SIZE_16_DP, end = SIZE_16_DP)
                    .clickable {
                        val newTheme = themeName == darkThemeName
                        isDarkTheme = newTheme
                        onThemeChange(themeName == darkThemeName)
                    },

                border = BorderStroke(
                    width = SIZE_1_DP,
                    color = secondaryOrange
                ),
                elevation = CardDefaults.cardElevation(SIZE_4_DP),
                title = {
                    Text(
                        modifier = Modifier.padding(start = SIZE_16_DP),
                        text = themeName,
                        style = LocalCatTypography.current.body1,

                    )
                },

                cardIcon = {

                    IconButton(
                        modifier = Modifier.padding(end = SIZE_10_DP),
                        onClick = { onThemeChange(themeName == darkThemeName) }) {
                        Icon(
                            painter = if (themeName == lightThemeName) {
                                painterResource(id = CatIcons.LightMode)
                            } else painterResource(id = CatIcons.DarkMode),
                            tint = primaryOrange /*if (isDarkTheme) primaryOrange else primaryGray*/,
                            contentDescription = "Theme icon",
                        )
                    }

                }
            )

        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun CatSettingsScreenPreview() {
    var isDarkTheme by rememberSaveable { mutableStateOf(true) }
    CatSettingsScreen(onThemeChange = { isDarkTheme = it })

}