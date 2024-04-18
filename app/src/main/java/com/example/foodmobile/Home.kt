package com.example.foodmobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodmobile.TopButton
import com.example.foodmobile.ui.theme.FoodMobileTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button


val test = Recipe(1,"","","", arrayListOf("",""))
val categories = listOf("chicken", "beef", "pizza", "hamburger", "chips", "kebab")
@Composable
fun Home() {
    Column(
        modifier = Modifier.fillMaxSize(),
    )
    {
        SearchBar()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            for (category in categories) {
                TopButton(text = category)
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
fun TopButton(text: String){
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(start = 4.dp, end = 4.dp)
    )
    {
        Text(text = text)
    }
}


@Preview(name = "Home", showBackground = true)
@Composable
fun HomePreview(){
    FoodMobileTheme {
        Home()
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
