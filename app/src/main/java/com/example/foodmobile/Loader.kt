package com.example.foodmobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(name = "Loader preview", showBackground = true, showSystemUi = true)
@Composable
fun Loader(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.food_logo_graphics_1_70)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
        Title(
            title = "FoodArk",
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)

        )
    }
}

@Composable
fun Title(title: String, modifier: Modifier = Modifier){
    Text(text = title,
        fontSize = 100.sp,
        textAlign = TextAlign.Center
    )
}