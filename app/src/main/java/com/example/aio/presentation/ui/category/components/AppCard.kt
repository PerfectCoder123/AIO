package com.example.aio.presentation.ui.category.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aio.app.android.WebViewActivity
import com.example.aio.presentation.theme.Roboto
import com.example.aio.presentation.ui.home.data.Brand

@Composable
fun AppCard(modifier: Modifier = Modifier, brand: Brand) {
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
            contentDescription = "category image",
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(10.dp)
                .size(48.dp),
        )
        Text(modifier = Modifier.padding(top = 10.dp), text = brand.name, style = TextStyle(fontSize = 16.sp, fontFamily = Roboto))

    }
}