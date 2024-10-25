// Theme.kt
package com.example.greenspot.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    background = Background, // Nastavení modrého pozadí
    surface = Color(0xFFF5F5F5),
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun GreenSpotTheme(
    darkTheme: Boolean = false, // Volitelné: Podpora tmavého režimu
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme // Použití světlého barevného schématu

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
