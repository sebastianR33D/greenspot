package com.example.greenspot

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.greenspot.database.HourDataRepository
import com.example.greenspot.database.HourDataDTO
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.ui.text.style.TextAlign


import androidx.compose.runtime.rememberCoroutineScope
@Composable
fun Screen2(hourDataRepository: HourDataRepository) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope() // Přidání coroutine scope
    var savedHourData by remember { mutableStateOf<List<HourDataDTO>>(emptyList()) } // Uložená data

    // Načtení uložených dat z databáze
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            savedHourData = hourDataRepository.getAllHourData()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Uložená data
        ExpandableSavedPriceSection("Uložená data", savedHourData)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ExpandableSavedPriceSection(title: String, prices: List<HourDataDTO>) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Tlačítko pro rozbalení a sbalení sekce
            Button(
                onClick = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (expanded) "Skrýt $title" else "Zobrazit $title")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Pokud je sekce rozbalená, zobrazíme obsah
            if (expanded) {
                if (prices.isNotEmpty()) {
                    TableHeader() // Recyklování stejné funkce pro zobrazení hlavičky
                    prices.forEach { price ->
                        SavedPriceRow(price)
                        Spacer(modifier = Modifier.height(4.dp)) // Přidání mezery mezi řádky
                    }
                } else {
                    Text(text = "Žádná data nejsou uložena", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun SavedPriceRow(price: HourDataDTO) {
    // Barvy pro různé úrovně ceny
    val backgroundColor = when (price.level) {
        "low" -> Color(0xFF035D1F) // Světle zelená
        "medium" -> Color(0xFFFF9800) // Světle žlutá
        "high" -> Color(0xFFF44336) // Světle červená
        else -> Color.LightGray // Pro unknown
    }

    val textColor = Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(8.dp)
    ) {
        Text(text = price.hour.toString(), modifier = Modifier.weight(1f), color = textColor)
        Text(text = price.priceCZK.toString(), modifier = Modifier.weight(1f), color = textColor)
        Text(text = price.level.replaceFirstChar { it.uppercase() }, modifier = Modifier.weight(1f).padding(start = 16.dp), color = textColor) // Přidání paddingu vlevo
        Text(text = price.levelNum.toString(), modifier = Modifier.weight(1f), textAlign = TextAlign.End, color = textColor) // Zarovnání doprava
    }
}

