package com.mobile.cat.ui.components.cards

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.theme.CatShapes
import com.mobile.cat.ui.theme.CatTheme
import com.mobile.cat.ui.theme.SIZE_10_DP
import com.mobile.cat.ui.theme.SIZE_1_DP
import com.mobile.cat.ui.theme.SIZE_20_DP
import com.mobile.cat.ui.theme.SIZE_4_DP
import com.mobile.cat.ui.theme.SIZE_8_DP
import com.mobile.cat.ui.theme.primaryOrange
import com.mobile.cat.ui.theme.secondaryOrange
import com.mobile.cat.ui.theme.systemRed

@Composable
fun CatCardMain(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,    // Cat breed name from Api
    shape: Shape = CatShapes.small,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
    cardIcon: @Composable () -> Unit = {}, // Favorites icon
    cardImage: @Composable () -> Unit = {}, // Cat image from Api
) {

    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border

    ) {
        Column {
            Box(contentAlignment = Alignment.TopEnd) {
                cardImage()
                cardIcon()
            }

            Row(
                horizontalArrangement = Arrangement.Absolute.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                title()
            }
        }


    }

}

@Preview(showSystemUi = true)
@Composable
fun  CatCardMainLazyGridPreview() {

    val catList = listOf("Siberian", "Abessynian", "Other", "British", "Persian", "Domestic")

    val context = LocalContext.current

    var isClicked by remember {
        mutableStateOf(false)
    }

    var clickedIndex by rememberSaveable { mutableIntStateOf(-1) }

    CatTheme {

        LazyVerticalGrid(
            modifier = Modifier.padding(SIZE_10_DP),
            columns = GridCells.Fixed(2),
            content = {
                items(catList.size) { item ->
                    CatCardMain(
                        modifier = Modifier
                            .padding(SIZE_10_DP)
                            .clickable {
                                Toast
                                    .makeText(
                                        context,
                                        "Card clicked",
                                        Toast.LENGTH_LONG
                                    )
                                    .show()
                            }
                        ,

                        title = {
                            Text(
                                modifier = Modifier.padding(horizontal = SIZE_8_DP, vertical = SIZE_20_DP),
                                text = catList[item]

                            )
                        },
                        border = BorderStroke(
                            width = SIZE_1_DP,
                            color = secondaryOrange
                        ),
                        elevation = CardDefaults.cardElevation(SIZE_4_DP),

                        cardImage = {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(SIZE_8_DP),
                                alignment = Alignment.Center,
                                contentScale = ContentScale.Crop,
                                painter = painterResource(id = CatIcons.CatLogo),
                                contentDescription = null,
                            )
                        },

                        cardIcon = {

                            var isClicked by remember {
                                mutableStateOf(false)
                            }

                            val iconColor = if (isClicked) {
                                Color.Red
                            } else {
                                primaryOrange.copy(0.75f)
                            }

                            IconButton(
                                onClick = {
                                    clickedIndex = item
                                    Toast
                                        .makeText(
                                            context,
                                            "Favorites  icon clicked",
                                            Toast.LENGTH_LONG
                                        )
                                        .show()

                                }
                            ) {
                                Icon(
                                    painter =
                                    painterResource(
                                        when{
                                            item == clickedIndex -> CatIcons.FavoritesFilled
                                            else -> CatIcons.FavoritesBorder
                                        }
                                       ),
                                    tint = systemRed,
                                    contentDescription = null,
                                )

                            }


                        }

                    )
                }

            }

        )

    }

}