package com.example.kotlinlesson0604_2and3.date.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {

    @Query("SELECT * FROM Person ORDER BY firstName ASC")
    fun getAll(): List<PersonEntity>
    @Insert
    fun insert(person: PersonEntity)
    @Delete
    fun delete(person: PersonEntity)
}