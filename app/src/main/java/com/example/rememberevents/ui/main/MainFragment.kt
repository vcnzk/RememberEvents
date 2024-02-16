package com.example.rememberevents.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.rememberevents.data.ListOfEvents
import com.example.rememberevents.adapter.ItemAdapter
import com.example.rememberevents.databinding.FragmentMainBinding
import androidx.fragment.app.viewModels


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TAGG", "class MainFragment : Fragment(). override fun onCreateView")
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Здесь обрабатываем события UI
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAGG", "class MainFragment : Fragment(). override fun onViewCreated")

        updateList()

        binding.imageSend.setOnClickListener {
            viewModel.addItemInList(binding.inputTextEvent.text.toString())
            hideKeyboard(view)
            updateList()
        }

        binding.listName.setOnClickListener {
            updateList()
            viewModel.printEvents()
        }
    }



    // Добавить функции для работы с UI
    private fun hideKeyboard(view: View): Boolean {
        Log.d("myEvent", "hideKeyboard")
        val inputMethodManager =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager?.hideSoftInputFromWindow(view.windowToken, 0)
        return true
    }

    private fun updateList() {
        val listOfEvents = ListOfEvents.getListOfEvents()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = context?.let { ItemAdapter(it, listOfEvents) }       // ??? Какой контекст передавать в ItemAdapter
        recyclerView.setHasFixedSize(true)      // Use this setting if you know that changes in content do not change the layout size of the RecyclerView
    }
}