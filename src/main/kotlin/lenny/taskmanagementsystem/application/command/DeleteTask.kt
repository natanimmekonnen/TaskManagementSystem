package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.model.TaskType
import lenny.taskmanagementsystem.domain.repository.TaskRepository
import org.springframework.stereotype.Service



@Service
class DeleteTaskUseCase(
    private val taskRepository: TaskRepository
) {

    fun execute(id: String) {
        taskRepository.deleteById(id)
    }
}