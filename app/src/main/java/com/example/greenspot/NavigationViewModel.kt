package com.example.greenspot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NavigationViewModel : ViewModel() {

    // Funkce pro zpracování navigace
    fun navigateToScreen1(onNavigate: () -> Unit) {
        viewModelScope.launch {
            onNavigate()  // Spustí se navigační funkce
        }
    }

    fun navigateToScreen2(onNavigate: () -> Unit) {
        viewModelScope.launch {
            onNavigate()
        }
    }

    fun navigateToScreen3(onNavigate: () -> Unit) {
        viewModelScope.launch {
            onNavigate()
        }
    }

    fun navigateToScreen4(onNavigate: () -> Unit) {
        viewModelScope.launch {
            onNavigate()
        }
    }
}
