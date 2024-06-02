package com.example.aio.presentation.ui.category.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aio.presentation.ui.home.data.Brand
import com.example.aio.presentation.ui.home.utility.BrandList

@Composable
fun AppView(header : String) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ){
        CategoryHeader(header = header)
        AppGrid(
            items = getListFromCategory(header),
            columns = 3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalSpacing = 10.dp,
            horizontalSpacing = 10.dp
        ) { category ->
            AppCard(brand = category)
        }
    }
}

fun getListFromCategory(category: String): List<Brand> {
    return when(category){
        "Shopping" -> BrandList.shoppingApp
        "Beauty" -> BrandList.beautyApp
        "Travel" -> BrandList.travelApp
        "Food" -> BrandList.foodApp
        "Grocery" -> BrandList.groceryApp
        "Medicine" -> BrandList.medicineApp
        "Top Brand" -> BrandList.shoppingApp + BrandList.beautyApp + BrandList.travelApp + BrandList.foodApp + BrandList.groceryApp + BrandList.medicineApp
        else -> BrandList.shoppingApp
    }
}