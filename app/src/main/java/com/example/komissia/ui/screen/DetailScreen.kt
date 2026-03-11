package com.example.komissia.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.komissia.ui.viewmodel.MainViewModel

@Composable
fun DetailScreen(
    id: String,
    viewModel: MainViewModel = hiltViewModel()
) {

    val story by viewModel.selectedStory.collectAsState()

    LaunchedEffect(id) {
        viewModel.loadStoryDetail(id)
    }

    if (story == null) {

        Text("Loading...")

    } else {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text("Title: ${story?.title}")

            Text("Author: ${story?.author}")

            Text("URL: ${story?.url}")

        }
    }
}