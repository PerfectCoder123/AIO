package com.example.aio.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aio.presentation.theme.Roboto
import com.example.aio.presentation.ui.home.data.Category

@Composable
fun AllCategories(
    categoryList: List<Category>,
    navController: NavController
) {
    Column (
        Modifier.padding(top = 10.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "All Categories",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Roboto
                )
            )
            Text(
                modifier = Modifier.clickable {
                  navController.navigate("all-category")
                },
                text = "See all",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ){
            categoryList.forEach{
                CategoryCard(category = it){
                    navController.navigate("app-category/${it.name}")
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: Category,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                 onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = category.image),
            contentDescription = "category image",
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(10.dp)
                .size(48.dp),
        )
        Text(modifier = Modifier.padding(top = 10.dp), text = category.name, style = TextStyle(fontSize = 16.sp, fontFamily = Roboto))

    }
}