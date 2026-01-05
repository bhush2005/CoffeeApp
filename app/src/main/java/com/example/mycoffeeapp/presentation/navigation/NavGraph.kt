package com.example.mycoffeeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mycoffeeapp.presentation.Screens.Welcomescreen.WelcomeScreen
import com.example.mycoffeeapp.presentation.Screens.detailscreen.DetailScreen
import com.example.mycoffeeapp.presentation.Screens.homescreen.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen) {
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.DetailScreen> { backStackEntry ->

            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            DetailScreen(productId = args.productID, navController)

        }
    }
}