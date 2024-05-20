package com.mobile.cat.ui.screens.main.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.mobile.cat.data.remote.CatImageResponse
import com.mobile.cat.navigation.CatRoutes
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.components.cards.CatCardMain
import com.mobile.cat.ui.theme.primaryOrange
import com.mobile.cat.ui.theme.secondaryOrange
import com.mobile.cat.ui.theme.systemRed
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun  LazyGridCards(
    navHostController: NavHostController,
    catImages: List<CatImageResponse>
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
        modifier = Modifier.padding( 10.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(catImages.size) { index ->
                val catImage = catImages[index]
                //val breedName = catImage.breeds.firstOrNull()?.name ?: "Unknown"
                val breedName = if(!catImage.breeds.isNullOrEmpty()){
                    catImage.breeds.firstOrNull()?.name ?: "Unknown"
                }else {"Unknown"}

                CatCardMain(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navHostController.navigate(CatRoutes.DETAILS)
                        },

                    title = {
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 20.dp),
                            text = breedName,
                            textAlign = TextAlign.Center

                        )
                    },
                    border = BorderStroke(
                        width = 1.dp,
                        color = secondaryOrange
                    ),
                    elevation = CardDefaults.cardElevation(4.dp),

                    cardImage = {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
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