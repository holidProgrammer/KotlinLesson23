package com.example.kotlinlesson0604_2and3.date.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class PersonEntity(
    @PrimaryKey
    val passportId: String,
    val firstName: String,
    val age: Int
)