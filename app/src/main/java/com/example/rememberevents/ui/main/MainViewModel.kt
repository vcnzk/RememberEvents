package com.example.rememberevents.ui.main

import androidx.lifecycle.ViewModel
import com.example.rememberevents.model.Event
import com.example.rememberevents.data.ListOfEvents

class MainViewModel : ViewModel() {
    private val listOfEvents = ListOfEvents

    fun addItemInList(text: String) {
        listOfEvents.addItemInList(Event(text))
    }

    fun delItemFromList(index: Int) {
        listOfEvents.delItemFromList(index)
    }

    fun printEvents() {
        listOfEvents.printEvents()
    }
}