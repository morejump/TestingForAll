package thao.luu.van.todoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import thao.luu.van.todoapp.model.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo ORDER BY createdAt DESC")
    fun getAllTodo() : Flow<List<ToDo>>

    @Insert
    fun addTodo(todo : ToDo)

    @Query("Delete FROM ToDo where id = :id")
    fun deleteTodo(id : Int)

}