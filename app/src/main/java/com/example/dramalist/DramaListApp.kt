package com.example.dramalist

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dramalist.ui.component.BottomNavigation
import com.example.dramalist.ui.navigation.Screen
import com.example.dramalist.ui.screen.detail.DetailScreen
import com.example.dramalist.ui.screen.drama.DramaScreen
import com.example.dramalist.ui.screen.home.HomeScreen
import com.example.dramalist.ui.screen.profile.ProfileScreen
import com.example.dramalist.ui.theme.DramaListTheme

@Composable
fun DramaListApp(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { it ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Screen.Home.route){
                HomeScreen(
                    navigateToDetail = { id ->
                        navController.navigate(Screen.Detail.createRoute(id))
                    }
                )
            }
            composable(route = Screen.Drama.route){
                DramaScreen(
                    navigateToDetail = { id ->
                        navController.navigate(Screen.Detail.createRoute(id))
                    }
                )
            }
            composable(route = Screen.Profile.route){
                ProfileScreen()
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("id"){
                    type = NavType.IntType
                })
            ) {
                val id = it.arguments?.getInt("id") ?: 0
                Log.d("D", "$id")
                DetailScreen(
                    id = id,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}

@Preview
@Composable
private fun DramaListAppPreview() {
    DramaListTheme {
        DramaListApp()
    }
}