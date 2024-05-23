package com.mobile.cat.presentation.screens.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.mobile.cat.ui.theme.LocalCatTypography
import com.mobile.cat.ui.theme.SIZE_5_DP

@Composable
fun CatDetailsText(
    modifier: Modifier = Modifier,
    prefix: String,
    suffix: String,
) {
    Text(
        modifier = Modifier.padding(vertical = SIZE_5_DP),
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(prefix.toString())
            }
            append(suffix)
        },
        style = LocalCatTypography.current.body1
    )
}