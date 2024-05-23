package com.mobile.cat.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mobile.cat.presentation.CatMainViewModel
import com.mobile.cat.presentation.screens.home.components.LazyGridCards
import com.mobile.cat.presentation.screens.home.components.SearchBarMain


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CatHomeScreen(
    navHostController: NavHostController,
    viewModel: CatMainViewModel = viewModel()
) {

    val catImages by viewModel.filteredCatImagesState.collectAsState()

    Column {
        SearchBarMain(viewModel = viewModel)
        LazyGridCards(navHostController, catImages, viewModel = viewModel)
    }

}