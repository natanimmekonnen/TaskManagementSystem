package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.factory.TaskFactory
import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.model.TaskType
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AddTaskToProjectUseCase(
    private val projectRepository: ProjectRepository,
    private val taskFactory: TaskFactory
) {
    fun execute(
        projectId: String,
        title: String,
        description: String,
        type: TaskType,
        dueDate: String?
    ): Project? {

        val project = projectRepository.findById(projectId) ?: return null

        val task = taskFactory.create(
            title = title,
            description = description,
            type = type,
            dueDate = dueDate
        )

        val updatedProject = project.copy(
            tasks = project.tasks + task
        )

        return projectRepository.save(updatedProject)
    }
}