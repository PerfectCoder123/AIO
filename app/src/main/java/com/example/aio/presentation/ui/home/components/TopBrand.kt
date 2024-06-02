package com.example.aio.presentation.ui.home.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aio.app.android.WebViewActivity
import com.example.aio.presentation.theme.Roboto
import com.example.aio.presentation.ui.home.data.Brand
import com.example.aio.presentation.ui.home.utility.BrandList

@Composable
fun TopBrand(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier.padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Top Brand",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Roboto
                )
            )
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate("app-category/Top Brand")
                    },
                text = "See all",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        val brands = listOf(
            BrandList.shoppingApp[0],
            BrandList.foodApp[1],
            BrandList.medicineApp[1],
            BrandList.beautyApp[2],
            BrandList.travelApp[0],
            BrandList.shoppingApp[6],
            BrandList.shoppingApp[7],
            BrandList.shoppingApp[3]
        )
        Grid(
            items = brands,
            columns = 4,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalSpacing = 10.dp,
            horizontalSpacing = 10.dp
        ) { brand ->
            BrandCard(brand = brand)
        }
    }
}

@Composable
fun BrandCard(modifier: Modifier = Modifier, brand: Brand){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                val intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra("url", brand.url)
                context.startActivity(intent)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = brand.image),
            contentDescription = "brand image",
            modifier = Modifier
                .background(Color.White, CircleShape)
                .padding(10.dp)
                .size(32.dp),
        )
        Text(
            text = brand.name,
            style = TextStyle(fontSize = 16.sp, fontFamily = Roboto)
        )
    }
}

@Composable
fun Grid(
    items: List<Brand>,
    columns: Int,
    modifier: Modifier = Modifier,
    verticalSpacing: Dp,
    horizontalSpacing: Dp,
    itemContent: @Composable (Brand) -> Unit
) {
    val rows = (items.size + columns - 1) / columns
    Column(modifier) {
        for (rowIndex in 0 until rows) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = if (rowIndex < rows - 1) verticalSpacing else 0.dp),
                horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
            ) {
                for (columnIndex in 0 until columns) {
                    val itemIndex = rowIndex * columns + columnIndex
                    if (itemIndex < items.size) {
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            itemContent(items[itemIndex])
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
