package com.example.aio.presentation.ui.category.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aio.presentation.theme.Roboto
import com.example.aio.presentation.theme.primaryAppColor

@Composable
fun CategoryHeader(header : String) {
    Text(modifier = Modifier.fillMaxWidth().padding(10.dp), text = header,
        style = TextStyle(
            fontSize = 22.sp,
            fontFamily = Roboto,
            color = primaryAppColor,
            fontWeight = FontWeight.SemiBold
        ),
        textAlign = TextAlign.Center
    )
}