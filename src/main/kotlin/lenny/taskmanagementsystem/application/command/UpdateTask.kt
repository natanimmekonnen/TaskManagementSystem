package lenny.taskmanagementsystem.application.command

import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class UpdateTaskStatusUseCase(
    private val projectRepository: ProjectRepository
) {
    fun execute(projectId: String, taskId: String, newStatus: TaskStatus): Boolean {

        val project = projectRepository.findById(projectId) ?: return false

        val updatedTasks = project.tasks.map { task ->
            if (task.id == taskId) {
                task.copy(status = newStatus)
            } else task
        }

        val updatedProject = project.copy(tasks = updatedTasks)

        projectRepository.save(updatedProject)
        return true
    }
}
