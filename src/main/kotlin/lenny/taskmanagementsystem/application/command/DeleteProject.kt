package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class DeleteProjectUseCase(
    private val projectRepository: ProjectRepository
) {
    fun execute(projectId: String) {
        projectRepository.deleteById(projectId)
    }
}