package com.example.bmi2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Record::class), version = 1)
//抽象類別需要在前面加上abstract
abstract class GameDatabase : RoomDatabase() {
    abstract  fun recordDao() : RecordDao
}