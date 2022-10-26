package com.example.kotlinlesson0604_2and3.date.model

import java.util.*

data class Person(
    val passportId: String = UUID.randomUUID().toString(),
    val age: Int,
    val name: String
)