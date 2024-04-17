package com.example.foodmobile

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodmobile.ui.theme.FoodMobileTheme
import org.w3c.dom.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodMobileTheme {
                        FoodMobileLoad()
                    }
                }
            }
        }
    }
}


@Composable
fun Title(title: String, modifier: Modifier = Modifier){
    Text(text = title,
        fontSize = 100.sp,
        textAlign = TextAlign.Center
    )
}
@Composable
fun FoodMobileLoad(modifier: Modifier = Modifier){
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

@Preview(showBackground = true)
@Composable
fun FoodMobilePreview() {
    FoodMobileTheme {
    FoodMobileLoad(

    )
    }
}