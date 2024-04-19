package com.example.foodmobile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodmobile.ui.theme.FoodMobileTheme

data class Ingredients(val nom: String, val quantite: Int)
//En attendant l'implémentation api
//val recipes = arrayOf(

    //Ingredients("pomme", "farine", "sucre", "oeufs")

)
@Composable
fun Home(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Title(title = "Home")
        Text(text = "test", color = MaterialTheme.colorScheme.primary)
    }
}

@Preview(name = "Home", showBackground = true)
@Composable
fun HomePreview(){
    FoodMobileTheme {
        Home()
    }
}