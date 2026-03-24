package lenny.taskmanagementsystem.infrastructure

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "projects")
data class ProjectDocument(
    @Id
    val id: String,
    val name: String,
    val description: String,
    val tasks: List<TaskDocument> = emptyList()
)
