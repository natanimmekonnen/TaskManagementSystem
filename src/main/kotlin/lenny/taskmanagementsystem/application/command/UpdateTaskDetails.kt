package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskType
import lenny.taskmanagementsystem.domain.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class UpdateTaskDetailsUseCase(
    private val taskRepository: TaskRepository
) {

    fun execute(
        id: String,
        title: String,
        description: String,
        type: TaskType,
        dueDate: String?,
        projectId: String?,
    ): Boolean {

        val task = taskRepository.findById(id) ?: return false
        val newPriority=when(type){
            TaskType.PERSONAL-> TaskPriority.LOW
            TaskType.WORK -> TaskPriority.MEDIUM
            TaskType.URGENT -> TaskPriority.HIGH
        }

        val updatedTask = task.copy(
            title = title,
            description = description,
            type = type,
            priority = newPriority,
            dueDate = dueDate,
            projectId = projectId,

        )

        taskRepository.update(updatedTask)

        return true
    }
}
