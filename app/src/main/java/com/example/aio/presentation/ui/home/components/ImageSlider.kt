package com.example.aio.presentation.ui.home.components

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.aio.app.android.WebViewActivity
import com.example.aio.presentation.ui.home.data.SliderItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider() {

    val images = listOf(
       SliderItem(
           image = "https://consumer-app-images.pharmeasy.in/marketing/comp_india_covered.jpg",
           url = "https://www.pharmeasy.in"
       ),
        SliderItem(
            image = "https://c.ndtvimg.com/2024-02/pkjgimpg_myntra-women-apparel_625x300_04_February_24.jpeg?im=FitAndFill,algorithm=dnn,width=620,height=350?downsize=360:*",
            url = "https://www.myntra.com"
        ),
        SliderItem(
            image = "https://www.jiomart.com/images/cms/aw_rbslider/slides/1717177803_Biscuits_Mela.jpg?im=Resize=(768,448)",
            url = "https://www.jiomart.com"
        ),
        SliderItem(
            image = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=720/layout-engine/2023-07/Pet-Care_WEB.jpg",
            url = "https://grofers.com"
        )
    )
    val pagerState = rememberPagerState {
        images.size
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            ImageCard(images[page])
        }

        DotsIndicator(
            totalDots = images.size,
            selectedIndex = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

@Composable
fun ImageCard(sliderItem: SliderItem) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
            .clickable {
                val intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra("url", sliderItem.url)
                context.startActivity(intent)
            },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(sliderItem.image
                )
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        repeat(totalDots) { index ->
            val size = if (index == selectedIndex) 12.dp else 8.dp
            val color = if (index == selectedIndex) Color.White else Color.Gray
            Box(
                modifier = Modifier
                    .size(size)
                    .padding(2.dp)
                    .background(color, CircleShape)
            )
        }
    }
}
