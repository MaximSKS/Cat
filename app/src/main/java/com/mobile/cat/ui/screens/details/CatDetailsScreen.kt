package com.mobile.cat.ui.screens.details

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mobile.cat.navigation.CatRoutes
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.components.appbars.CatTopAppBar
import com.mobile.cat.ui.theme.LocalCatTypography
import com.mobile.cat.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CatDetailsScreen(navHostController: NavHostController) {

    val textMap = mapOf(
        "Breed: " to "Siberian",
        "Weight: " to "4-7 kg",
        "Life span: " to "12-15 years",
        "Origin: " to "Russia",
        "Temperament: " to "Curious, Intelligent, Loyal, Sweet, Agile, Playful, Affectionate",
        "Child friendly: " to "4",
        "Dog friendly: " to "5",
        "Energy level: " to "5",
        "Intelligence: " to "5",
        "Description: " to "\nThe Siberians cat like temperament and affection makes the ideal lap cat and will live quite happily indoors. Very agile and powerful, the Siberian cat can easily leap and reach high places, including the tops of refrigerators and even doors.",
    )

    Scaffold(
        topBar = {
            CatTopAppBar(
                title = "Details",
                navHostController = navHostController,
                navigationRoute = CatRoutes.HOME
//                onIconClick = {
//                    navHostController.navigate(CatRoutes.HOME)
//                }
            )
        },

        ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues /*horizontal = 20.dp, vertical = 40.dp*/)
            //.padding(start = 10.dp, end = 10.dp, top = 40.dp)

        ) {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .padding(horizontal = 20.dp)
                        .background(color = Color.DarkGray, shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillHeight,
                    painter = painterResource(id = CatIcons.CatLogo),
                    contentDescription = null,
                )

                Spacer(modifier = Modifier.height(28.dp))

                Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                    textMap.forEach { (key, value) ->

                        CatDetailsText(
                            prefix = key,
                            suffix = value
                        )

                    }

                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, bottom = 15.dp)
                ) {
                    Text(
                        modifier = Modifier.clickable { navHostController.navigate(CatRoutes.WIKIPEDIA) },
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.learn_more))
                            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                            append(stringResource(id = R.string.wikipedia))
                            pop(index = 0)
                        },
                        style = LocalCatTypography.current.strongUnderlined
                    )

                }


            }

        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun CatDetailsScreenPreview() {
    val navController = rememberNavController()
    CatDetailsScreen(navController)
}