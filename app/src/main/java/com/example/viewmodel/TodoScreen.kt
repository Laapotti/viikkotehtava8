package com.example.todo.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.ui.theme.TodoTheme
import com.example.viewmodel.Todo
import com.example.viewmodel.TodoViewModel

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
    val todos = remember { todoViewModel.todos }

    if (todos.isNotEmpty()) {
        TodoList(todos = todos)
    } else {
        Text("Loading...")
    }
}

@Composable
fun TodoList(todos: List<Todo>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos.size) { index ->
            Text(
                text = todos[index].title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoScreen() {
    TodoTheme {
        TodoList(todos = listOf(Todo(1, 1, "Sample Todo", false)))
    }
}
