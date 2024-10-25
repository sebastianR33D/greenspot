package com.example.greenspot.database

import com.example.greenspot.api.HourData
import com.example.greenspot.database.HourDataDao
import com.example.greenspot.database.HourDataDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HourDataRepository(private val hourDataDao: HourDataDao) {

    // Uložení dat do Room
    suspend fun saveHourData(hourDataList: List<HourData>) {
        withContext(Dispatchers.IO) {
            val hourDataDTOs = hourDataList.map {
                HourDataDTO(
                    hour = it.hour,
                    priceCZK = it.priceCZK,
                    level = it.level,
                    levelNum = it.levelNum
                )
            }
            hourDataDao.insertAll(hourDataDTOs)
        }
    }

    // Načtení všech uložených dat z Room
    suspend fun getAllHourData(): List<HourDataDTO> {
        return withContext(Dispatchers.IO) {
            hourDataDao.getAllHourData()
        }
    }
}
