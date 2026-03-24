package lenny.taskmanagementsystem.application.query

import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class GetTaskFromProjectUseCase(
    private val projectRepository: ProjectRepository
) {
    fun execute(projectId: String, taskId: String): Task? {
        val project = projectRepository.findById(projectId) ?: return null
        return project.tasks.find { it.id == taskId }
    }
}