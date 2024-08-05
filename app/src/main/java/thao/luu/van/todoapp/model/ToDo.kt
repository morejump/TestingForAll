package thao.luu.van.todoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    var title : String,
    var createdAt : Date
)


