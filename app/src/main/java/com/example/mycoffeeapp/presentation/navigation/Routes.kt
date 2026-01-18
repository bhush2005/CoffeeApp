package com.example.mycoffeeapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object WelcomeScreen : Routes()

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    data class DetailScreen(val productID: Int) : Routes()

    @Serializable
    object CartScreen : Routes()

    @Serializable
    object ProfileScreen : Routes()

    @Serializable
    object FavoriteScreen : Routes()



}