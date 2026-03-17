package lenny.taskmanagementsystem.application.query


import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class GetAllProjectsUseCase(
    private val projectRepository: ProjectRepository
) {
    fun execute(): List<Project> {
        return projectRepository.findAll()
    }
}