package com.example.aio.presentation.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.example.aio.R

@Preview(showSystemUi = true)
@Composable
fun Splash(navController: NavController = rememberNavController()) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
    val progress by animateLottieCompositionAsState(composition, iterations = 1)

    LaunchedEffect(progress) {
        if (progress == 1f) {
            navController.popBackStack()
            navController.navigate("home")
        }
    }

    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = Modifier
            .fillMaxSize()
            .padding(80.dp)
    )
}
