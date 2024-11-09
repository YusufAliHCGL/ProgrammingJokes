package com.example.softwaredeveloperjokes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.softwaredeveloperjokes.ui.theme.SoftwareDeveloperJokesTheme
import com.example.softwaredeveloperjokes.view.HomeScreen
import com.example.softwaredeveloperjokes.viewmodel.JokesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoftwareDeveloperJokesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val navController = rememberNavController()
                    val viewModel by remember {
                        viewModels<JokesViewModel>()
                    }
                    NavHost(navController = navController, startDestination = "home_screen") {
                        composable(route = "home_screen") {
                            HomeScreen(
                                viewModel = viewModel,
                                paddingValues = innerPadding
                            )
                        }
                    }
                }
            }
        }
    }
}
