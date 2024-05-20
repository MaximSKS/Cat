package com.mobile.cat.ui.screens.settings

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
import androidx.compose.ui.unit.dp
import com.mobile.cat.R
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.components.cards.CatCardSecondary
import com.mobile.cat.ui.theme.LocalCatTypography
import com.mobile.cat.ui.theme.primaryGray
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
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .clickable {
                        val newTheme = themeName == darkThemeName
                        isDarkTheme = newTheme
                        onThemeChange(themeName == darkThemeName)
                    },

                border = BorderStroke(
                    width = 1.dp,
                    color = secondaryOrange
                ),
                elevation = CardDefaults.cardElevation(4.dp),
                title = {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = themeName,
                        style = LocalCatTypography.current.body1,

                    )
                },

                cardIcon = {

                    IconButton(
                        modifier = Modifier.padding(end = 10.dp),
                        onClick = { onThemeChange(themeName == darkThemeName) }) {
                        Icon(
                            painter = if (themeName == lightThemeName) {
                                painterResource(id = CatIcons.LightMode)
                            } else painterResource(id = CatIcons.DarkMode),
                            tint =  if (isDarkTheme) primaryOrange else primaryGray,
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