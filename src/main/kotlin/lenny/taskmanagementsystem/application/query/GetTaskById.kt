package lenny.taskmanagementsystem.application.query

import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class GetTaskByIdUseCase(
    private val taskRepository: TaskRepository
) {
    fun execute(taskId: String): Task? {
        return taskRepository.findById(taskId)
    }
}