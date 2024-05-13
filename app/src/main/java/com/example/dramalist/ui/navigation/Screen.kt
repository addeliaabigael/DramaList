package com.example.dramalist.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Drama : Screen("drama")
    object Profile : Screen("profile")
    object Detail : Screen("home/{id}") {
        fun createRoute(id: Int) = "home/$id"
    }
}