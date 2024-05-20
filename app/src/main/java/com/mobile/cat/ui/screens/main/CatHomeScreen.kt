package com.mobile.cat.ui.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mobile.cat.presentation.CatMainViewModel
import com.mobile.cat.ui.screens.main.components.LazyGridCards
import com.mobile.cat.ui.screens.main.components.SearchBarMain


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CatHomeScreen(
    navHostController: NavHostController,
    catViewModel: CatMainViewModel = viewModel()
) {

    val catImages by catViewModel.catImagesState.collectAsState()

    Column {
        SearchBarMain()
        LazyGridCards(navHostController, catImages)
    }

}