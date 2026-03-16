package com.example.komissia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
<<<<<<< HEAD
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import com.example.komissia.ui.screen.StoryListScreen
import com.example.komissia.ui.theme.KomissiaTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.komissia.ui.navigation.NavGraph
=======
import com.example.komissia.ui.navigation.NavGraph
import com.example.komissia.ui.theme.KomissiaTheme
import dagger.hilt.android.AndroidEntryPoint
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
<<<<<<< HEAD

=======
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
<<<<<<< HEAD

            KomissiaTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NavGraph()

                }
            }
        }
    }
}
=======
            KomissiaTheme {
                NavGraph()
            }
        }
    }
}
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
