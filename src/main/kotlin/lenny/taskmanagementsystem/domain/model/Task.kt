package lenny.taskmanagementsystem.domain.model

data class Task(
    val id: String,
    val title: String,
    val description: String,
    val status: TaskStatus,
    val type: TaskType,
    val priority: TaskPriority,
//    val assignedUser: String?,
    val dueDate: String?,
    val activities: List<Activity> = emptyList()
    )