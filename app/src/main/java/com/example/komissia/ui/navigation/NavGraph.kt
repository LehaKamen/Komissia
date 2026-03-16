package com.example.komissia.ui.navigation

import androidx.compose.runtime.Composable
<<<<<<< HEAD
import androidx.navigation.compose.*
=======
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
import com.example.komissia.ui.screen.DetailScreen
import com.example.komissia.ui.screen.StoryListScreen

@Composable
fun NavGraph() {
<<<<<<< HEAD

=======
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
<<<<<<< HEAD

        composable("list") {

            StoryListScreen(navController)

        }

        composable("detail/{id}") { backStackEntry ->

            val id = backStackEntry.arguments?.getString("id") ?: ""

            DetailScreen(id)

        }

    }
}
=======
        composable("list") {
            StoryListScreen(navController)
        }

        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            DetailScreen(id = id, navController = navController)
        }
    }
}
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
