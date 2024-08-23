//package com.mobile.cat.presentation.screens
//
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.mobile.cat.navigation.CatRoutes
//import com.mobile.cat.ui.components.appbars.CatTopAppBar
//import com.mobile.cat.ui.theme.LocalCatTypography
//import com.mobile.cat.ui.theme.SIZE_12_DP
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun WikipediaScreen(navHostController: NavHostController) {
//
//    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//
//    Scaffold(
//        modifier = Modifier
//            .nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            CatTopAppBar(
//                title = "Wikipedia",
//                navHostController = navHostController,
//                navigationRoute = CatRoutes.DETAILS
//                ) }
//    ) { paddingValues ->
//
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//        ) {
//            items(10) {
//                Text(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(top = SIZE_12_DP)
//                        .wrapContentHeight(),
//                    text = "Wikipedia screen test",
//                    textAlign = TextAlign.Center,
//                    style = LocalCatTypography.current.headline3
//
//                )
//            }
//
//        }
//
//    }
//}