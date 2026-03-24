package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskType
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class UpdateTaskDetailsUseCase(
    private val projectRepository: ProjectRepository
) {

    fun execute(
        projectId: String,
        taskId: String,
        title: String,
        description: String,
        type: TaskType,
        dueDate: String?
    ): Boolean {

        val project = projectRepository.findById(projectId) ?: return false

        val newPriority = when (type) {
            TaskType.PERSONAL -> TaskPriority.LOW
            TaskType.WORK -> TaskPriority.MEDIUM
            TaskType.URGENT -> TaskPriority.HIGH
        }

        val updatedTasks = project.tasks.map { task ->
            if (task.id == taskId) {
                task.copy(
                    title = title,
                    description = description,
                    type = type,
                    priority = newPriority,
                    dueDate = dueDate
                )
            } else task
        }

        val updatedProject = project.copy(tasks = updatedTasks)

        projectRepository.save(updatedProject)
        return true
    }
}
