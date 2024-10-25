package com.example.greenspot.database



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HourDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(hourData: List<HourDataDTO>)

    @Query("SELECT * FROM hour_data_table")
    suspend fun getAllHourData(): List<HourDataDTO>
}
