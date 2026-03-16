package lenny.taskmanagementsystem.application.query

import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class GetAllTasksUseCase(
    private val taskRepository: TaskRepository
) {
    fun execute(): List<Task> {
        return taskRepository.findAll()
    }
}