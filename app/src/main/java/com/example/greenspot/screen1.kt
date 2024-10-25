package com.example.greenspot

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.greenspot.viewmodel.ApiViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.greenspot.api.HourData
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.ui.text.style.TextAlign
import com.example.greenspot.database.HourDataRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import androidx.compose.runtime.rememberCoroutineScope


@Composable
fun Screen1(apiViewModel: ApiViewModel = viewModel(), hourDataRepository: HourDataRepository) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope() // Přidání coroutine scope
    val hoursToday = apiViewModel.hoursToday.collectAsState().value // Získáme hodnotu mimo korutinu

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Dnešní ceny
        ExpandablePriceSection("Dnešní ceny", prices = hoursToday)

        Spacer(modifier = Modifier.height(16.dp))

        // Zítřejší ceny
        ExpandablePriceSection("Zítřejší ceny", prices = apiViewModel.hoursTomorrow.collectAsState().value)

        Spacer(modifier = Modifier.height(16.dp))

        // Tlačítko pro uložení dat
        Button(
            onClick = {
                // Použití coroutine scope pro spuštění asynchronní operace při kliknutí na tlačítko
                coroutineScope.launch {
                    hourDataRepository.saveHourData(hoursToday) // Použijeme hodnotu mimo composable
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Uložit data")
        }
    }
}





@Composable
fun ExpandablePriceSection(title: String, prices: List<HourData>) {
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
                    TableHeader()
                    prices.forEach { price ->
                        PriceRow(price)
                        Spacer(modifier = Modifier.height(4.dp)) // Přidání mezery mezi řádky
                    }
                } else {
                    Text(text = "Načítám data...", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun TableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Hodina", modifier = Modifier.weight(1f))
        Text(text = "Cena Kč/MWh", modifier = Modifier.weight(1f))
        Text(text = "Úroveň", modifier = Modifier.weight(1f).padding(start = 16.dp)) // Přidání paddingu vlevo
        Text(text = "Level", modifier = Modifier.weight(1f), textAlign = TextAlign.End)
    }
}

@Composable
fun PriceRow(price: HourData) {
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
