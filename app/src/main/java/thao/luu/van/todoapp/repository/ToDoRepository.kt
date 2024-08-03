package thao.luu.van.todoapp.repository

import kotlinx.coroutines.flow.Flow
import thao.luu.van.todoapp.model.ToDo

interface ToDoRepository {
    fun getAll(): Flow<List<ToDo>>
    suspend fun insert(toDoItem: ToDo)
    suspend fun delete(id: Int)
}
