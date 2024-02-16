package com.example.rememberevents.data

import android.util.Log
import com.example.rememberevents.model.Event

object ListOfEvents {
    private val listOfEvents: MutableList<Event> = mutableListOf()

    fun getListOfEvents(): List<Event> {
        return listOfEvents
    }
    fun addItemInList(item: Event) {
        listOfEvents.add(item)
    }

    fun delItemFromList(index: Int) {
        listOfEvents.removeAt(index)
    }

    fun clearList() {
        listOfEvents.clear()
    }

    fun printEvents() {
        for (event in listOfEvents) {
            Log.d("myEvent", "Current event is ${event.event}")
        }
    }
}