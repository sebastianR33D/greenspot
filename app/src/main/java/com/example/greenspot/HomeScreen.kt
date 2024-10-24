package com.example.greenspot

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController, viewModel: NavigationViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,  // Vertikální zarovnání na střed obrazovky
        horizontalAlignment = Alignment.CenterHorizontally  // Horizontální zarovnání na střed obrazovky
    ) {
        Button(
            onClick = { viewModel.navigateToScreen1 { navController.navigate("screen1") } },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Spotové ceny",  // Změna textu na "Spotové ceny"
                fontSize = 30.sp
            )
        }
        Button(
            onClick = { viewModel.navigateToScreen2 { navController.navigate("screen2") } },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Stránka 2",
                fontSize = 30.sp
            )
        }
        Button(
            onClick = { viewModel.navigateToScreen3 { navController.navigate("screen3") } },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Stránka 3",
                fontSize = 30.sp
            )
        }
        Button(
            onClick = { viewModel.navigateToScreen4 { navController.navigate("screen4") } },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Stránka 4",
                fontSize = 30.sp
            )
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
