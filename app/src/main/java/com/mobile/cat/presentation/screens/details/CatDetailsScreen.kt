package com.mobile.cat.presentation.screens.details

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.mobile.cat.R
import com.mobile.cat.navigation.CatRoutes
import com.mobile.cat.ui.components.appbars.CatTopAppBar
import com.mobile.cat.ui.theme.CatShapes
import com.mobile.cat.ui.theme.LocalCatTypography
import com.mobile.cat.ui.theme.SIZE_15_DP
import com.mobile.cat.ui.theme.SIZE_16_DP
import com.mobile.cat.ui.theme.SIZE_280_DP
import com.mobile.cat.ui.theme.SIZE_28_DP
import com.mobile.cat.ui.theme.SIZE_50_DP


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CatDetailsScreen(
    navHostController: NavHostController,
    catImage: String,
    breedName: String,
    weight: String,
    lifeSpan: String,
    origin: String,
    adaptability: Int,
    hypoallergenic: Int,
    temperament: String,
    childFriendly: Int,
    dogFriendly: Int,
    strangerFriendly: Int,
    sheddingLevel: Int,
    affectionLevel: Int,
    socialNeeds: Int,
    energyLevel: Int,
    intelligence: Int,
    description: String,
    wikipediaUrl: String,
) {

     val detailsText = mapOf(

        R.string.details_breed to breedName,
        R.string.details_weight to weight,
        R.string.details_life_span to lifeSpan,
        R.string.details_origin to origin,
        R.string.details_adaptability to adaptability,
        R.string.details_hypoallergenic to hypoallergenic,
        R.string.details_temperament to temperament,
        R.string.details_child_friendly to childFriendly,
        R.string.details_dog_friendly to dogFriendly,
        R.string.details_stranger_friendly to strangerFriendly,
        R.string.details_shedding_level to sheddingLevel,
        R.string.details_affection_level to affectionLevel,
        R.string.details_social_needs to socialNeeds,
        R.string.details_energy_level to energyLevel,
        R.string.details_intelligence to intelligence,
        R.string.details_description to description,
    )


    Scaffold(

        topBar = {
            CatTopAppBar(
                title = stringResource(id = R.string.details_top_bar),
                navHostController = navHostController,
                navigationRoute = CatRoutes.HOME
            )
        },

        ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {

                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(SIZE_280_DP)
                        .padding(horizontal = SIZE_16_DP)
                        .clip(CatShapes.small)
                        .background(color = Color.Transparent),
                    contentScale = ContentScale.Crop,
                    painter = rememberAsyncImagePainter(model = catImage),
                    contentDescription = "Cat image",
                )

                Spacer(modifier = Modifier.height(SIZE_28_DP))

                Column(modifier = Modifier.padding(horizontal = SIZE_16_DP)) {

                    detailsText.forEach { (key, value) ->

                        CatDetailsText(
                            prefix = stringResource(id = key),
                            suffix = value.toString()
                        )

                    }

                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = SIZE_50_DP, bottom = SIZE_15_DP)
                ) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(wikipediaUrl))
                                navHostController.context.startActivity(intent)
                            },
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.learn_more))
                            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                            append(stringResource(id = R.string.wikipedia))
                            pop(index = 0)
                        },
                        style = LocalCatTypography.current.textLink1
                    )

                }


            }

        }

    }

}