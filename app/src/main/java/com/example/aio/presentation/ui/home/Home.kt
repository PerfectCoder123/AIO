package com.example.aio.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.aio.R
import com.example.aio.presentation.theme.White10
import com.example.aio.presentation.ui.home.components.AllCategories
import com.example.aio.presentation.ui.home.components.App
import com.example.aio.presentation.ui.home.components.ImageSlider
import com.example.aio.presentation.ui.home.components.LogoHeader
import com.example.aio.presentation.ui.home.components.SearchHeader
import com.example.aio.presentation.ui.home.components.TopBrand
import com.example.aio.presentation.ui.home.utility.BrandList
import com.example.aio.presentation.ui.home.viewmodel.SearchViewModel

@Composable
fun Home(navController: NavController ) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White10)
            .verticalScroll(rememberScrollState())
    ){
        val searchViewModel = viewModel(modelClass = SearchViewModel::class.java)
        val search = searchViewModel.search.collectAsState()
        val searchAvailablestate = searchViewModel.isAvailable.collectAsState()
        LogoHeader()
        SearchHeader(viewModel = searchViewModel)
        if(searchAvailablestate.value) {
            if (search.value == "") ImageSlider()
            if (search.value == "") AllCategories(
                categoryList = BrandList.categoryList,
                navController = navController
            )
            if (search.value == "") TopBrand(navController = navController)
            if (searchViewModel.isMatching(
                    BrandList.shoppingApp,
                    "Shopping"
                )
            ) App(
                brandList = BrandList.shoppingApp,
                category = "Shopping",
                navController = navController
            )
            if (searchViewModel.isMatching(
                    BrandList.beautyApp,
                    "Beauty"
                )
            ) App(
                brandList = BrandList.beautyApp,
                category = "Beauty",
                navController = navController
            )
            if (searchViewModel.isMatching(
                    BrandList.travelApp,
                    category = "Travel"
                )
            ) App(
                brandList = BrandList.travelApp,
                category = "Travel",
                navController = navController
            )
            if (searchViewModel.isMatching(
                    BrandList.foodApp,
                    category = "Food"
                )
            ) App(brandList = BrandList.foodApp, category = "Food", navController = navController)
            if (searchViewModel.isMatching(BrandList.groceryApp, category = "Grocery")) App(
                brandList = BrandList.groceryApp,
                category = "Grocery",
                navController = navController
            )
            if (searchViewModel.isMatching(BrandList.medicineApp, category = "Medicine")) App(
                brandList = BrandList.medicineApp,
                category = "Medicine",
                navController = navController
            )

        }
        else{
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp),
                painter = painterResource(id = R.drawable.not_found), contentDescription = "not found")
        }
    }
}