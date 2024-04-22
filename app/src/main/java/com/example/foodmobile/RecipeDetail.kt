package com.example.foodmobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodmobile.ui.theme.FoodMobileTheme


@Composable
fun RecipeDetailPage(recipeId: Int, navController: NavController){
    val image = painterResource(id = R.drawable.pizza_stock)
    val recipe = testRecipes.get(recipeId)
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Image(
            painter = image,
            contentDescription = "Image de la recette ${recipe.title}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth()
        )
        Column (modifier = Modifier.padding(start = 15.dp)) {
            CardTitle(text = recipe.title)
            Text(text = recipe.updatedAt, modifier = Modifier.padding(top = 5.dp))
            for(ingredient in recipe.ingredients){
                Column (modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = ingredient, fontSize = 15.sp)
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {

            Button(onClick = { navController.navigate(Route.Home.name) }) {
                Text(text = "Retour")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RecipeDetailPreview(){
    FoodMobileTheme {
        val navController = rememberNavController()
        RecipeDetailPage(0, navController)
    }
}