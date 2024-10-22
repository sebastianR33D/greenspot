package com.example.greenspot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp  // Import správné jednotky dp
import com.example.greenspot.ui.theme.GreenSpotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenSpotTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainMenu(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainMenu(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Button(
            onClick = { /* TODO: Navigate to Screen 1 */ },
            modifier = Modifier.padding(16.dp)  // Použití dp pro padding
        ) {
            Text(text = "Stránka 1")
        }
        Button(
            onClick = { /* TODO: Navigate to Screen 2 */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Stránka 2")
        }
        Button(
            onClick = { /* TODO: Navigate to Screen 3 */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Stránka 3")
        }
        Button(
            onClick = { /* TODO: Navigate to Screen 4 */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Stránka 4")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    GreenSpotTheme {
        MainMenu()
    }
}
