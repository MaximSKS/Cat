package com.mobile.cat.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.theme.CatTheme
import com.mobile.cat.ui.theme.DarkDefaultColorScheme
import com.mobile.cat.ui.theme.PADDING_20_DP
import com.mobile.cat.ui.theme.secondaryOrange

@Composable
fun CatCard(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,    // Cat breed name from Api
    shape: Shape = RoundedCornerShape(8.dp),
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
    cardImage: @Composable () -> Unit = {}, // Cat image from Api
    ) {

    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border

    ) {
            Box() {
                cardImage()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(PADDING_20_DP)
                        .background(color = MaterialTheme.colorScheme.background)
                        .alpha(0.5f)
                ){
                    title()
                }


            }


    }


}
// Test screen after splash screen
@Composable
fun CatPaw() {
    Column(
        modifier = Modifier.fillMaxSize()//.background(primaryWhite)

    ) {

        Box{
            Image(
                modifier = Modifier
                    .alpha(0.2f)
                    .fillMaxSize()
                    .scale(1.1f)
                    .blur(2.dp),
                painter =
                if (MaterialTheme.colorScheme == DarkDefaultColorScheme) {
                    painterResource(id = CatIcons.BackgroundDark)
                } else painterResource(id = CatIcons.BackgroundLight),
                contentDescription = null,
            )

            Image(
                modifier = Modifier
                    .size(130.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = CatIcons.CatLogo),
                contentDescription = null,
            )
        }

    }

}


@Preview
@Composable
fun PawPreview() {
    CatTheme {
        CatCard(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 20.dp)
                .height(100.dp),
            title = { Text(text = "Siberian")},
            border =  BorderStroke(
                width = 1.dp,
                color = secondaryOrange
            ),

            cardImage = {
                Image(
                    modifier = Modifier

                        .size(120.dp),
                    painter = painterResource(id = CatIcons.CatLogo),
                    contentDescription = null,
                )
            }

        )
    }

}