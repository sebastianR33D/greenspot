package com.example.greenspot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greenspot.ui.theme.GreenSpotTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()  // Inicializace ViewModelu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenSpotTheme {
                val navController = rememberNavController()  // Inicializace NavControlleru
                Scaffold { innerPadding ->
                    NavigationHost(
                        navController = navController,
                        viewModel = mainViewModel,  // Předání ViewModelu
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController, viewModel: MainViewModel, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "home",  // Výchozí obrazovka (Home)
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(navController = navController, viewModel = viewModel)  // Předání ViewModelu
        }
        composable("screen1") {
            Screen1()
        }
        composable("screen2") {
            Screen2()
        }
        composable("screen3") {
            Screen3()
        }
        composable("screen4") {
            Screen4()
        }
    }
}
