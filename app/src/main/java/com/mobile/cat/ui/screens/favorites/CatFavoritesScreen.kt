package com.mobile.cat.ui.screens.favorites


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.mobile.cat.ui.components.cards.CatCardFavoritesPreview

@Composable
fun CatFavoritesScreen(){

    LazyColumn {
        item{
            repeat(10){
                CatCardFavoritesPreview()
            }
        }

    }
}