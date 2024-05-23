package com.mobile.cat.ui.components.appbars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.theme.primaryOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatTopAppBar(
    title: String,
    titleColor: Color = Color.Unspecified,
    navHostController: NavHostController,
    navigationRoute: String,
){

    TopAppBar(
        title = {
                Text(
                    text = title,
                    color = titleColor
                )
        },
        navigationIcon = {
            IconButton(onClick = { navHostController.navigate(navigationRoute) }) {
                Icon(
                    painter = painterResource(id = CatIcons.ArrowBack),
                    contentDescription = "Arrow back icon",
                    tint = primaryOrange
                )

            }
        },

        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.background),

    )

}