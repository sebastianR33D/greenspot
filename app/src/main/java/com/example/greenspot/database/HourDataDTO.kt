package com.example.greenspot.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hour_data_table")
data class HourDataDTO(
    @PrimaryKey val hour: Int,
    val priceCZK: Double,
    val level: String,
    val levelNum: Int
)
