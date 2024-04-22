package com.example.foodmobile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun RecipeDetail(recipe: Recipe){
    Text(text = recipe.title)
}

@Composable
@Preview
fun RecipeDetailPreview(){
    RecipeDetail(recipe = testRecipe)
}