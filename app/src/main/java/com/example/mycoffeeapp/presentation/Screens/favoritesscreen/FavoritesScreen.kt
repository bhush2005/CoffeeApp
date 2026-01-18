package com.example.mycoffeeapp.presentation.Screens.favoritesscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.modal.Product
import com.example.mycoffeeapp.presentation.ui_components.MyBottomNavBar
import java.nio.file.WatchEvent


@Composable
fun FavoritesScreen(navController: NavController) {

    var favoriteItems by remember {
        mutableStateOf(
            listOf(
                Product(
                    id = 1,
                    name = "Espresso",
                    description = "Strong and rich",
                    price = 3.80,
                    imageRes = R.drawable.coffee_2
                ),
                Product(
                    id = 2,
                    name = "Latte",
                    description = "Smooth and creamy",
                    price = 4.50,
                    imageRes = R.drawable.coffee_3
                ),
                Product(
                    id = 3,
                    name = "Cappuccino",
                    description = "With chocolate",
                    price = 4.20,
                    imageRes = R.drawable.coffee_1
                )
            )
        )
    }

    Scaffold(
        topBar = { FavoriteScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController = navController, "Favorites") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item{
                favoriteItems.forEach { product ->
                    FavoriteitemCard(
                        product,
                        onRemove = { favoriteItems = favoriteItems - product})
                }
            }
        }
    }
}