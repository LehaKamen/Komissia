package com.example.komissia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.komissia.ui.screen.DetailScreen
import com.example.komissia.ui.screen.StoryListScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            StoryListScreen(navController)
        }

        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            DetailScreen(id = id, navController = navController)
        }
    }
}
