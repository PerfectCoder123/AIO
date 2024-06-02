package com.example.aio.presentation.ui.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aio.presentation.ui.category.components.CategoryGrid
import com.example.aio.presentation.ui.category.components.CategoryHeader
import com.example.aio.presentation.ui.home.components.CategoryCard
import com.example.aio.presentation.ui.home.utility.BrandList

@Composable
fun CategoryView(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ){
        CategoryHeader(header = "All Categories")
        CategoryGrid(
            items = BrandList.categoryList,
            columns = 3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalSpacing = 10.dp,
            horizontalSpacing = 10.dp
        ) { category ->
            CategoryCard(category = category, onClick = {
                navController.navigate("app-category/${category.name}")
            })
        }
    }
}