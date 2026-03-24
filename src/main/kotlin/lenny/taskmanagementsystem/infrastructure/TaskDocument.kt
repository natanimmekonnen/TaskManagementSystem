package lenny.taskmanagementsystem.infrastructure

import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.model.TaskType

data class TaskDocument(
    val id: String,
    val title: String,
    val description: String,
    val status: TaskStatus,
    val type: TaskType,
    val priority: TaskPriority,
    val dueDate: String?,
    val activities: List<ActivityDocument> = emptyList()
)