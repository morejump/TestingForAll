package thao.luu.van.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import thao.luu.van.todoapp.model.ToDo
import thao.luu.van.todoapp.repository.ToDoRepository
import java.time.Instant
import java.util.Date

class ToDoViewModel(private var repository: ToDoRepository) : ViewModel() {

    val toDoList : Flow<List<ToDo>> = repository.getAll()

    fun addTodo(title : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(ToDo(title = title, createdAt = Date.from(Instant.now())))
        }
    }

    fun deleteTodo(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(id)
        }
    }


}