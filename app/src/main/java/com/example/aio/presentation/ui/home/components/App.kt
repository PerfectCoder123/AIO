package com.example.aio.presentation.ui.home.components

import android.content.Intent
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aio.app.android.WebViewActivity
import com.example.aio.presentation.theme.Roboto
import com.example.aio.presentation.ui.home.data.Brand

@Composable
fun App(modifier: Modifier = Modifier, brandList : List<Brand>, category: String, navController: NavController) {
    Column (
        modifier.padding(top = 10.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = category,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Roboto
                )
            )
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate("app-category/$category")
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
            brandList.forEach { brand ->
                AppCard(brand)
            }
        }
    }
}

@Composable
fun AppCard(brand : Brand) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                val intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra("url", brand.url)
                context.startActivity(intent)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = brand.image),
            contentDescription = brand.name,
            modifier = Modifier
                .background(Color.White, CircleShape)
                .padding(10.dp)
                .size(32.dp),
        )
        Text(text = brand.name, style = TextStyle(fontSize = 14.sp, fontFamily = Roboto))

    }
}