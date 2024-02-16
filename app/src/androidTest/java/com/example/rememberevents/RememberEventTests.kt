package com.example.rememberevents

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.example.rememberevents.adapter.ItemAdapter
import com.example.rememberevents.data.ListOfEvents

@RunWith(AndroidJUnit4::class)
class RememberEventTests {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun getTextFromEditText() {
        val testText = "test?!"
//        val context = InstrumentationRegistry.getInstrumentation().context
//        val adapter = ItemAdapter(context, ListOfEvents.getListOfEvents())

        onView(withId(R.id.input_text_event))
            .perform(typeText(testText))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.image_send)).perform(click())


    }
}