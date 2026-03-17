package lenny.taskmanagementsystem.application.query


import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class GetProjectByIdUseCase(
    private val projectRepository: ProjectRepository
) {
    fun execute(id: String): Project? {
        return projectRepository.findById(id)
    }
}