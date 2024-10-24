package com.example.greenspot.api

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Datové třídy odpovídající JSON struktuře
data class HourData(
    val hour: Int,
    val priceEur: Double,
    val priceCZK: Double,
    val level: String,
    val levelNum: Int
)

data class PriceResponse(
    val hoursToday: List<HourData>,
    val hoursTomorrow: List<HourData>
)

// Rozhraní pro API
interface SpotPriceApiService {

    // Endpoint pro získání kompletní ceny jako JSON
    @GET("api/v1/price/get-prices-json")
    suspend fun getPrices(): PriceResponse
}

// Objekt pro vytvoření Retrofit instance
object SpotPriceApi {
    private const val BASE_URL = "https://spotovaelektrina.cz/"

    val retrofitService: SpotPriceApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Gson konvertor pro JSON
            .build()
            .create(SpotPriceApiService::class.java)
    }
}
