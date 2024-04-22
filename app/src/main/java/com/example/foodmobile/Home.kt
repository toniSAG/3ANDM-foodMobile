package com.example.foodmobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import java.util.Locale


val testRecipe = Recipe(1,"pizza","url","", arrayListOf("pate a pizza","tomate"))
val testRecipes = listOf<Recipe>(
    Recipe(1,"pizza","url","23 Janvier, 2023", arrayListOf("pâte a pizza","2 tomates", "100g de fromage à raper", "6 tranches de peperoni")),
    Recipe(2,"pâte carbonara","url","5 Juin, 2019", arrayListOf("250g de penne", "3 oeufs", "200g de parmesan", "100g de lardons")),
    Recipe(3,"pâte bolognaise","url","6 Septembre, 2015", arrayListOf("250g de spaghetti","150g de sauce bolognaise")),
    Recipe(4,"tartiflette","url","25 Décembre, 2023", arrayListOf("4 - 5 pommes de terre","200g de lardons", "2 reblochons")),
)
val categories = listOf("chicken", "beef", "pizza", "hamburger", "chips", "kebab", "bbq", "pasta")
@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        SearchBar()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(start = 5.dp),
        ) {
            for (category in categories) {
                TopButton(
                    text = category,
                    Modifier.padding(end = 10.dp)
                )
            }
        }
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            for(recipe in testRecipes){
                RecipeCard(recipe, navController)
            }
        }
    }
}

@Composable
fun SearchBar(){
    val text = remember {
        mutableStateOf("")
    }
    TextField(
        value = text.value,
        onValueChange = {
            newText ->
            text.value = newText
        },
        placeholder = { Text(text = "Cherchez une recette") },
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
    )
}

@Composable
fun TopButton(text: String, modifier: Modifier = Modifier){
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(start = 4.dp, end = 4.dp),
        modifier = modifier
    )
    {
        Text(text = text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
    }
}

@Composable
fun RecipeCard(recipe: Recipe, navController: NavController){
    val recipeId = testRecipes.indexOf(recipe);
    val image = painterResource(id = R.drawable.pizza_stock)
    Card (
        modifier = Modifier
            .padding(5.dp)
            .clickable { navController.navigate("${Route.Details.name}/$recipeId") },
    ) {
        Image(
            painter = image,
            contentDescription = "Image de la recette ${recipe.title}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth()
        )
        CardTitle(
            text = recipe.title,
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp, top = 20.dp)
        )
    }
}

@Composable
fun CardTitle(text: String, modifier: Modifier = Modifier){
    Text(
        text = text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
        fontSize = 30.sp,
        modifier = modifier
    )
}

@Preview(name = "Home", showBackground = true)
@Composable
fun HomePreview(){
    FoodMobileTheme {
        val navController = rememberNavController()
        Home(navController = navController)
    }
}

@Preview
@Composable
fun SearchBarPreview(){
    FoodMobileTheme {
        SearchBar()
    }
}

@Preview
@Composable
fun TopButtonPreview(){
    FoodMobileTheme {
        TopButton("toto")
    }
}

@Preview(showSystemUi = false)
@Composable
fun RecipeCardPreview(){
    val navController = rememberNavController()
    RecipeCard(recipe = testRecipe, navController)
}

@Preview
@Composable
fun CardTitlePreview(){
    CardTitle(text = "toto")
}
