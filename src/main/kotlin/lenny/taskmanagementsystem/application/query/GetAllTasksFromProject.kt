package lenny.taskmanagementsystem.application.query

import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class GetTasksByProjectUseCase(
    private val projectRepository: ProjectRepository
) {
    fun execute(projectId: String): List<Task> {
        val project = projectRepository.findById(projectId) ?: return emptyList()
        return project.tasks
    }
}