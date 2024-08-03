package thao.luu.van.todoapp.repository

import kotlinx.coroutines.flow.Flow
import thao.luu.van.todoapp.db.ToDoDao
import thao.luu.van.todoapp.model.ToDo


class ToDoRepositoryImpl(private val toDoDao: ToDoDao) : ToDoRepository {

    override fun getAll(): Flow<List<ToDo>> = toDoDao.getAllTodo()

    override suspend fun insert(toDoItem: ToDo) {
        toDoDao.addTodo(toDoItem)
    }

    override suspend fun delete(id: Int) {
        toDoDao.deleteTodo(id)
    }
}