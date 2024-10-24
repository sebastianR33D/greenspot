package com.example.greenspot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greenspot.api.HourData
import com.example.greenspot.api.SpotPriceApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel : ViewModel() {

    // Uchováváme data pro dnešní a zítřejší hodiny
    private val _hoursToday = MutableStateFlow<List<HourData>>(emptyList())
    val hoursToday: StateFlow<List<HourData>> get() = _hoursToday

    private val _hoursTomorrow = MutableStateFlow<List<HourData>>(emptyList())
    val hoursTomorrow: StateFlow<List<HourData>> get() = _hoursTomorrow

    init {
        getPrices()
    }

    // Načtení cen z API (JSON odpověď)
    private fun getPrices() {
        viewModelScope.launch {
            try {
                val prices = SpotPriceApi.retrofitService.getPrices()
                _hoursToday.value = prices.hoursToday
                _hoursTomorrow.value = prices.hoursTomorrow
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
