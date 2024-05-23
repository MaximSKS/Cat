package com.mobile.cat.presentation.screens.favorites


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.components.cards.CatCardSecondary
import com.mobile.cat.ui.components.cards.CatCardSecondaryPreview
import com.mobile.cat.ui.theme.CatShapes
import com.mobile.cat.ui.theme.LocalCatTypography
import com.mobile.cat.ui.theme.SIZE_13_DP
import com.mobile.cat.ui.theme.SIZE_16_DP
import com.mobile.cat.ui.theme.SIZE_1_DP
import com.mobile.cat.ui.theme.SIZE_4_DP
import com.mobile.cat.ui.theme.SIZE_80_DP
import com.mobile.cat.ui.theme.secondaryOrange

@Composable
fun CatFavoritesScreen() {

    LazyColumn {
        item {

                CatCardSecondary(
                    modifier = Modifier
                        .padding(start = SIZE_16_DP, top = SIZE_16_DP, end = SIZE_16_DP)
                        .height(SIZE_80_DP)
                        .clickable { /*TODO*/ },

                    border = BorderStroke(
                        width = SIZE_1_DP,
                        color = secondaryOrange
                    ),
                    elevation = CardDefaults.cardElevation(SIZE_4_DP),
                    title = {
                        Text(
                            text = "Siberian",
                            style = LocalCatTypography.current.subtitle2
                        )
                    },
                    cardImage = {
                        Image(
                            modifier = Modifier
                                .height(SIZE_80_DP)
                                .background(color = Color.DarkGray, shape = CatShapes.small),
                            contentScale = ContentScale.FillHeight,
                            painter = painterResource(id = CatIcons.CatLogo),
                            contentDescription = null,
                        )
                    },

                    cardIcon = {

                        IconButton(
                            modifier = Modifier.padding(end = SIZE_13_DP),
                            onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = CatIcons.Delete),
                                tint = secondaryOrange,
                                contentDescription = "Delete icon",
                            )
                        }

                    }
                )

        }

    }
}