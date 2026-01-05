package com.example.mycoffeeapp.presentation.Screens.detailscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.modal.Product
import kotlinx.serialization.Serializable

@Composable
fun DetailScreen(productId : Int, navController: NavController){

    val products = listOf(
        Product(id = 1, name = "Espresso", description = "Strong and rich", price = 3.80, imageRes = R.drawable.coffee_2),
        Product(id = 2, name = "Latte", description = "Smooth and creamy", price = 4.50, imageRes = R.drawable.coffee_3),
        Product(id = 3, name = "Cappuccino", description = "With chocolate", price = 4.20, imageRes = R.drawable.coffee_1),
        Product(id = 4, name = "Mocha", description = "With cocoa flavor", price = 4.70, imageRes = R.drawable.coffee_4),
        Product(id = 5, name = "Macchiato", description = "Bold and milky", price = 4.60, imageRes = R.drawable.coffee_5),
        Product(id = 6, name = "Flat White", description = "Velvety smooth", price = 4.40, imageRes = R.drawable.coffee_6),
        Product(id = 7, name = "Iced Mocha", description = "Refreshing and rich", price = 4.70, imageRes = R.drawable.coffee_4)
    )

    val selectedProduct = products.find { it.id == productId }

    if (selectedProduct == null) {
        Text(text = "Product not found", color = Color.Red)
        return
    }

    Scaffold(
        topBar = {DetailScreenTopAppBar(navController) },
        bottomBar = { DetailScreenBottomBar() }
    ) { innerPadding ->

        LazyColumn {
            item {
                ProductDetailsContent(
                    selectedProduct,
                    innerPadding
                )
            }
        }

    }

}