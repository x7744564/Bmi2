package com.example.bmi2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecordDao {
    //避免插入的資料與資料庫重複，直接用OnConflictStrategy.REPLACE去更新資料
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(record: Record)

    @Query("select * from Record")
    fun getAll() : List<Record>
}