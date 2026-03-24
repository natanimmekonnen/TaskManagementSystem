package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.factory.ActivityFactory
import lenny.taskmanagementsystem.domain.factory.TaskFactory
import lenny.taskmanagementsystem.domain.model.Activity
import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AddActivityToTaskUseCase(
    private val projectRepository: ProjectRepository,
    private val activityFactory: ActivityFactory
) {
    fun execute(
        projectId: String,
        taskId: String,
        description: String,
        timestamp: String
    ): Project? {

        val project = projectRepository.findById(projectId) ?: return null

        val activity = activityFactory.create(
            id = UUID.randomUUID().toString(),
            description = description,
            timestamp = timestamp
        )

        val updatedTasks = project.tasks.map { task ->
            if (task.id == taskId) {
                task.copy(
                    activities = task.activities + activity
                )
            } else task
        }

        val updatedProject = project.copy(tasks = updatedTasks)

        return projectRepository.save(updatedProject)
    }
}