package com.example.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val _todos = mutableStateListOf<Todo>()
    val todos: List<Todo> get() = _todos

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val todosApi = TodosApi.getInstance()
                val fetchedTodos = todosApi.getTodos()
                _todos.clear()
                _todos.addAll(fetchedTodos) // Add data to MutableStateList
                Log.d("TODOVIEWMODEL", "Fetched ${fetchedTodos.size} todos")
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", "Error fetching todos: ${e.message}")
            }
        }
    }
}
