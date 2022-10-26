package com.example.kotlinlesson0604_2and3.date.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDao
}