package com.example.greenspot

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

@Composable
fun HomeScreen(navController: NavHostController, viewModel: MainViewModel) {
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
            Row(
                verticalAlignment = Alignment.CenterVertically,  // Vertikální zarovnání na střed v tlačítku
                horizontalArrangement = Arrangement.Center  // Horizontální zarovnání na střed v tlačítku
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Ikona Stránka 1",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Stránka 1",
                    fontSize = 18.sp
                )
            }
        }
        // Opakování pro ostatní tlačítka
        Button(
            onClick = { viewModel.navigateToScreen2 { navController.navigate("screen2") } },
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Ikona Stránka 2",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Stránka 2", fontSize = 18.sp)
            }
        }
        Button(
            onClick = { viewModel.navigateToScreen3 { navController.navigate("screen3") } },
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Ikona Stránka 3",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Stránka 3", fontSize = 18.sp)
            }
        }
        Button(
            onClick = { viewModel.navigateToScreen4 { navController.navigate("screen4") } },
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Ikona Stránka 4",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Stránka 4", fontSize = 18.sp)
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
        viewModel = MainViewModel()
    )
}
