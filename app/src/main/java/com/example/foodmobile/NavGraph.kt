package com.example.foodmobile

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Home.name) {
        composable(route = Route.Home.name){
            Home(navController)
        }
        composable(route= "${Route.Details.name}/{id}", arguments = listOf(navArgument(name = "id"){type = NavType.IntType})){
            backstackEntry ->
            backstackEntry.arguments?.let { RecipeDetailPage(recipeId = it.getInt("id"), navController) }
        }
    }
}

enum class Route(){
    Details,
    Home
}