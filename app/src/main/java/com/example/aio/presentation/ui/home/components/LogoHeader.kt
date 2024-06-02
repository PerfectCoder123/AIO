package com.example.aio.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aio.R
import com.example.aio.presentation.theme.BryGada
import com.example.aio.presentation.theme.Roboto
import com.example.aio.presentation.theme.primaryAppColor

@Preview(showSystemUi = true)
@Composable
fun LogoHeader(modifier: Modifier = Modifier) {

    Row (
        modifier = modifier.padding(top = 10.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier.weight(1f).padding(horizontal = 20.dp).size(32.dp),
            painter = painterResource(id = R.drawable.trolley),
            contentDescription = "app logo",
            alignment = Alignment.CenterStart
        )

        Text(
            modifier = Modifier.weight(1f),
            text = "AIO",
            style = TextStyle(
                fontSize = 26.sp,
                color = primaryAppColor,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                fontFamily = BryGada
            ),


        )
        Spacer(modifier = Modifier.weight(1f))
    }
}