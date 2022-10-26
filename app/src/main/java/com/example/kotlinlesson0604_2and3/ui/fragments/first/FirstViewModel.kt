package com.example.kotlinlesson0604_2and3.ui.fragments.first

import androidx.lifecycle.ViewModel
import com.example.kotlinlesson0604_2and3.date.repository.Repository

class FirstViewModel constructor(private val repo: Repository) : ViewModel() {
    fun saveToDatabase(per: com.example.kotlinlesson0604_2and3.date.model.Person) {
        repo.saveToDatabase(per)
    }
}