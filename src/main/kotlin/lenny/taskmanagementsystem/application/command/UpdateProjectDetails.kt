package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class UpdateProjectUseCase(
    private val projectRepository: ProjectRepository
) {
    fun execute(
        projectId: String,
        name: String,
        description: String
    ): Boolean {

        val project = projectRepository.findById(projectId) ?: return false

        val updatedProject = project.copy(
            name = name,
            description = description
        )

        projectRepository.save(updatedProject)
        return true
    }
}