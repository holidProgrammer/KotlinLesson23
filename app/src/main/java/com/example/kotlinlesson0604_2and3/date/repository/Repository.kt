package com.example.kotlinlesson0604_2and3.date.repository

import com.example.kotlinlesson0604_2and3.date.model.Person
import com.example.kotlinlesson0604_2and3.date.core.Resource
import com.example.kotlinlesson0604_2and3.date.room.PersonDao
import com.example.kotlinlesson0604_2and3.date.room.PersonEntity

class Repository(private val personDao: PersonDao) {

    fun getAllPersons(): List<Person> {
        Resource.Loading(null)
        return personDao.getAll().map {
            Person(
                passportId = it.passportId,
                age = it.age,
                name = it.firstName
            )
        }
    }

    fun saveToDatabase(person: Person) {
        val entity =
            PersonEntity(passportId = person.passportId, firstName = person.name, age = person.age)
        personDao.insert(entity)
    }
}
