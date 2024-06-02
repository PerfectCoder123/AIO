package com.example.aio.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aio.R
import com.example.aio.presentation.theme.Black100
import com.example.aio.presentation.ui.home.viewmodel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchHeader(modifier: Modifier = Modifier, viewModel: SearchViewModel) {
    var text by remember { mutableStateOf("") }
    val shape = RoundedCornerShape(24.dp)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp,end = 10.dp, bottom = 20.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        OutlinedTextField(
            modifier = Modifier
                .height(50.dp)
                .padding(horizontal = 10.dp)
                .weight(1f),
            shape = shape,
            textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
            value = text,
            onValueChange = { newText ->
                text = newText
                viewModel.updateSearch(newText)

            },
            placeholder = {
                Text(
                    text = "Search",
                    style = TextStyle(fontSize = 14.sp)
                )
            },
            singleLine = true,
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Black
            )
        )

        Box(
            modifier = Modifier
                .size(45.dp)
                .background(Black100, shape)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "filter",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
