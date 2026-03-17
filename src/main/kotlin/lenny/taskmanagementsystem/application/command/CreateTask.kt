package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.factory.TaskFactory
import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.model.TaskType
import lenny.taskmanagementsystem.domain.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class CreateTaskUseCase(
    private val taskRepository: TaskRepository,
    private val taskFactory: TaskFactory
) {
    fun execute(
        title: String,
        description: String,
        type: TaskType,
        dueDate: String?,
        projectId: String?,
//        priority: TaskPriority,
//        status: TaskStatus,
    ): Task {
        val task = taskFactory.create(
            title = title,
            description = description,
            type = type,
            dueDate = dueDate,
            projectId = projectId,

        )

       return taskRepository.save(task)
    }
}