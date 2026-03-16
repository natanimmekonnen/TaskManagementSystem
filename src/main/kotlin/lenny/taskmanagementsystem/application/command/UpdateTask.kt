package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class UpdateTaskStatusUseCase(
    private val taskRepository: TaskRepository
) {
    fun execute(taskId: String, newStatus: TaskStatus): Boolean {
        val task = taskRepository.findById(taskId) ?: return false
        val updatedTask = task.copy(status = newStatus)
        taskRepository.update(updatedTask)
        return true
    }
}