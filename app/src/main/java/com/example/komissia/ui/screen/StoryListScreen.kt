package com.example.komissia.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.komissia.ui.viewmodel.MainViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column

@Composable
fun StoryListScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    val stories by viewModel.stories.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadStories()
    }

    Column {

        Text(
            text = "Variant: HNALG-FRONT-MOD_D18_RETRY_POLICY",
            modifier = Modifier.padding(8.dp)
        )

        when {

            error != null -> {

                Column {

                    Text("Error: $error")

                    Button(
                        onClick = { viewModel.loadStories() }
                    ) {
                        Text("Retry")
                    }

                }

            }

            stories.isEmpty() -> {
                Text("Loading...")
            }

            else -> {

                LazyColumn {

                    items(stories) { story ->

                        Text(
                            text = story.title ?: "No title",
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    navController.navigate("detail/${story.id}")
                                }
                        )

                    }

                }

            }
        }
    }
}

