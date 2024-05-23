package com.mobile.cat.presentation.screens.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobile.cat.R
import com.mobile.cat.presentation.CatMainViewModel
import com.mobile.cat.ui.CatIcons
import com.mobile.cat.ui.theme.SIZE_10_DP
import com.mobile.cat.ui.theme.SIZE_16_DP
import com.mobile.cat.ui.theme.SIZE_20_DP
import com.mobile.cat.ui.theme.SIZE_50_DP
import com.mobile.cat.ui.theme.orange75

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarMain(viewModel: CatMainViewModel) {

    var text by rememberSaveable { mutableStateOf("") }
    var isActive by rememberSaveable { mutableStateOf(false) }
    val breeds by viewModel.breedsState.collectAsState()
    val filteredBreeds = breeds.filter { it.name.contains(text, ignoreCase = true) }


        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = SIZE_10_DP, horizontal = SIZE_20_DP),

            query = text,
            onQueryChange = {
                text = it
            },
            onSearch = {
                isActive = false
                viewModel.filterCatImagesByBreed(text)
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
            shape = RoundedCornerShape(SIZE_50_DP),

        ) {
            LazyColumn {
                items(filteredBreeds) { breed ->
                    Text(
                        text = breed.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(SIZE_16_DP)
                            .clickable {
                                isActive = false
                                text = breed.name
                                viewModel.filterCatImagesByBreed(text)
                            }
                    )
                }
            }
        }

}


@Preview(showSystemUi = true)
@Composable
fun SearchBarMainPreview() {
    SearchBarMain(viewModel = viewModel())
}