package com.example.kotlinlesson0604_2and3.ui.fragments.second

import com.example.kotlinlesson0604_2and3.date.model.Person
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson0604_2and3.date.core.UIState
import com.example.kotlinlesson0604_2and3.date.repository.Repository

class SecondViewModel constructor(private val repo: Repository) : ViewModel() {
    private val _mutableLiveData = MutableLiveData<UIState<List<Person>>>()
    val mutableLiveData = _mutableLiveData as LiveData<UIState<List<Person>>>
    fun getAllPerson() {
        _mutableLiveData.value = UIState.Success(repo.getAllPersons())
    }
}