package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.factory.ProjectFactory
import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service
import java.util.UUID
@Service
class CreateProject(
    private val projectRepository: ProjectRepository,
    private val projectFactory: ProjectFactory
) {
    fun execute(name: String, description: String): Project {
        val project = projectFactory.create(
            id = UUID.randomUUID().toString(),
            name,
            description
        )
        return projectRepository.save(project)
    }
}