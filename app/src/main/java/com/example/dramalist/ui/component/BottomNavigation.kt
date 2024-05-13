package com.example.dramalist.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dramalist.R
import com.example.dramalist.ui.navigation.NavigationItem
import com.example.dramalist.ui.navigation.Screen
import com.example.dramalist.ui.theme.DramaListTheme

@Composable
fun BottomNavigation(
    navController: NavController
) {
    NavigationBar(
        modifier = Modifier.height(75.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItem = listOf(
            NavigationItem(
                title = "Home",
                icon = painterResource(R.drawable.homeicon),
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Drama",
                icon = painterResource(R.drawable.movieicon),
                screen = Screen.Drama
            ),
            NavigationItem(
                title = "Profile",
                icon = painterResource(R.drawable.accounticon),
                screen = Screen.Profile
            ),
        )
        navigationItem.map { item ->
            val isSelected = currentRoute == item.screen.route
            NavigationBarItem(
                selected = isSelected,
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title,
                        tint = Color.White
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = Color.White
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.background
                ),
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    DramaListTheme(dynamicColor = false) {
        BottomNavigation(navController = rememberNavController())
    }
}