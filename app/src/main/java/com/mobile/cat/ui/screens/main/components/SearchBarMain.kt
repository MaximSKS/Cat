package com.mobile.cat.ui.screens.main.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.cat.R
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.theme.orange75

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarMain() {

    var text by rememberSaveable { mutableStateOf("") }
    var isActive by rememberSaveable { mutableStateOf(false) }

  //  Scaffold {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp),
            query = text,
            onQueryChange = {
                text = it
            },
            onSearch = {
                isActive = false
                text = ""
            },
            active = isActive,
            onActiveChange = {
                isActive = it
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_breed),
                    color = orange75
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = CatIcons.Search),
                    contentDescription = "Search icon",
                    tint = orange75
                )
            },
            trailingIcon = {
                if (isActive) {
                    Icon(
                        modifier = Modifier
                            .clickable {
                                if (text.isNotBlank())
                                    text = ""
                                else isActive = false
                            },

                        painter = painterResource(id = CatIcons.Clear),
                        contentDescription = "Clear icon",
                        tint = orange75
                    )
                }

            },
            shape = RoundedCornerShape(50.dp),
            //colors = SearchBarDefaults.colors(orange65),
        ) {
            // Lazy Column
        }
   // } // Scaffold end
}

@Preview(showSystemUi = true)
@Composable
fun SearchBarMainPreview() {
    SearchBarMain()
}