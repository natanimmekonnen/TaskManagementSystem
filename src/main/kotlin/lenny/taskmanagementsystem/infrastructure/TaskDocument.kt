package lenny.taskmanagementsystem.infrastructure

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tasks")
data class TaskDocument(
    @Id
    val id: String,
    val title: String,
    val status: String,
    val description: String,
    val type: String,
    val priority: String,
    val dueDate: String?,

)