package com.example.greenspot

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.greenspot.ui.theme.GreenSpotTheme
import androidx.compose.material3.MaterialTheme



@Composable
fun HomeScreen(navController: NavHostController, viewModel: NavigationViewModel) {
    GreenSpotTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Všechna tlačítka teď používají modrou barvu
            Button(
                onClick = { viewModel.navigateToScreen1 { navController.navigate("screen1") } },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Spotové ceny", fontSize = 30.sp)
            }

            Button(
                onClick = { viewModel.navigateToScreen2 { navController.navigate("screen2") } },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Historie", fontSize = 30.sp)
            }

            Button(
                onClick = { viewModel.navigateToScreen3 { navController.navigate("screen3") } },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Stránka 3", fontSize = 30.sp)
            }

            Button(
                onClick = { viewModel.navigateToScreen4 { navController.navigate("screen4") } },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Stránka 4", fontSize = 30.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Mock NavHostController a ViewModel pro náhled
    HomeScreen(
        navController = rememberNavController(),
        viewModel = NavigationViewModel()
    )
}
