package com.mobile.cat.presentation.screens.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.mobile.cat.data.remote.CatImageResponse
import com.mobile.cat.presentation.CatMainViewModel
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.components.cards.CatCardMain
import com.mobile.cat.ui.theme.SIZE_10_DP
import com.mobile.cat.ui.theme.SIZE_180_DP
import com.mobile.cat.ui.theme.SIZE_1_DP
import com.mobile.cat.ui.theme.SIZE_20_DP
import com.mobile.cat.ui.theme.SIZE_4_DP
import com.mobile.cat.ui.theme.SIZE_8_DP
import com.mobile.cat.ui.theme.primaryOrange
import com.mobile.cat.ui.theme.secondaryOrange
import com.mobile.cat.ui.theme.systemRed

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun  LazyGridCards(
    navHostController: NavHostController,
    catImages: List<CatImageResponse>,
    viewModel: CatMainViewModel,
    ) {

    val context = LocalContext.current

    var isClicked by remember {
        mutableStateOf(false)
    }

    var clickedIndex by rememberSaveable { mutableIntStateOf(-1) }

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },

    ) {

    LazyVerticalGrid(
        modifier = Modifier.padding(SIZE_10_DP),
        columns = GridCells.Fixed(2),
        content = {
            items(catImages.size) { index ->
                val catImage = catImages[index]
                val breed = catImage.breeds.firstOrNull()
                val breedName = breed?.name ?: "Unknown"

                CatCardMain(
                    modifier = Modifier
                        .padding(SIZE_10_DP)
                        .clickable {

                            val route = viewModel.getCatDetailsRoute(catImage)
                            navHostController.navigate(route)

                        },

                    title = {
                        Text(
                            modifier = Modifier.padding(horizontal = SIZE_8_DP, vertical = SIZE_20_DP),
                            text = breedName,
                            textAlign = TextAlign.Center

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
                                .height(SIZE_180_DP),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = rememberAsyncImagePainter(model = catImage.url),
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
//                                clickedIndex = index
//
//                                coroutineScope.launch {
//                                    snackbarHostState.showSnackbar("${catList[item]} added to favorites")
//                                }
                            }
                        ) {
                            Icon(
                                painter =
                                painterResource(
                                    when {
                                        index == clickedIndex -> CatIcons.FavoritesFilled
                                        else -> CatIcons.FavoritesBorder
                                    }
                                ),
                                tint = systemRed,
                                contentDescription = "Favorites icon",
                            )
                        }

                    }

                )
            }

        }

    )

}

}