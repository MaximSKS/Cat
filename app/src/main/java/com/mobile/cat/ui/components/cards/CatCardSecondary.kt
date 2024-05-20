package com.mobile.cat.ui.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.theme.LocalCatTypography
import com.mobile.cat.ui.theme.secondaryOrange

@Composable
fun CatCardSecondary(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,    // Cat breed name from Api
    shape: Shape = RoundedCornerShape(8.dp),
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
    cardIcon: @Composable () -> Unit = {},
    cardImage: @Composable () -> Unit = {}, // Cat image from Api
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)

        ) {
            cardImage()
            title()
            cardIcon()
        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun CatCardFavoritesPreview() {
    CatCardSecondary(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .height(80.dp)
            .clickable { /*TODO*/ }
        ,

        border = BorderStroke(
            width = 1.dp,
            color = secondaryOrange
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        title = {
            Text(
                text = "Siberian",
                style = LocalCatTypography.current.subtitle2
            )
        },
        cardImage = {
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .background(color = Color.DarkGray, shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillHeight,
                painter = painterResource(id = CatIcons.CatLogo),
                contentDescription = null,
            )
        },

        cardIcon = {

            IconButton(
                modifier = Modifier.padding(end = 13.dp),
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
