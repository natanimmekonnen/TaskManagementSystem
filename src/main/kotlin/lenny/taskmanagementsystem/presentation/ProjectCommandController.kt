package lenny.taskmanagementsystem.presentation

import lenny.taskmanagementsystem.application.command.AddActivityToTaskUseCase
import lenny.taskmanagementsystem.application.command.AddTaskToProjectUseCase
import lenny.taskmanagementsystem.application.command.CreateProject
import lenny.taskmanagementsystem.application.command.DeleteTaskUseCase
import lenny.taskmanagementsystem.application.command.UpdateTaskStatusUseCase
import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.model.TaskType
import org.springframework.data.mongodb.core.aggregation.Aggregation.project
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/commands/projects")
class ProjectCommandController(
    private val createProject: CreateProject,
    private val addTaskToProjectUseCase: AddTaskToProjectUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val updateTaskStatusUseCase: UpdateTaskStatusUseCase,
    private val addActivityToTaskUseCase: AddActivityToTaskUseCase
) {
    @PostMapping
    fun createProject(@RequestBody request: CreateProjectRequest) =
        createProject.execute(
            name = request.name,
            description = request.description
        )

    @PostMapping("/{projectId}/tasks")
    fun addTask(
        @PathVariable projectId: String,
        @RequestBody request: CreateTaskRequest
    ) = addTaskToProjectUseCase.execute(
            projectId,
            request.title,
            request.description,
            request.type,
            request.dueDate
        )

    @DeleteMapping("/{projectId}/tasks/{taskId}")
    fun deleteTask(
        @PathVariable projectId: String,
        @PathVariable taskId: String
    ) = deleteTaskUseCase.execute(projectId, taskId)

    @PutMapping("/{projectId}/tasks/{taskId}/status")
    fun updateTaskStatus(
        @PathVariable projectId: String,
        @PathVariable taskId: String,
        @RequestParam status: TaskStatus
    ) = updateTaskStatusUseCase.execute(projectId, taskId, status)


    @PostMapping("/{projectId}/tasks/{taskId}/activities")
    fun addActivity(
        @PathVariable projectId: String,
        @PathVariable taskId: String,
        @RequestBody request: CreateActivityRequest
    ) = addActivityToTaskUseCase.execute(
            projectId,
            taskId,
            request.description,
            request.timestamp
        )
}

data class CreateProjectRequest(
    val name: String,
    val description: String
)
data class CreateTaskRequest(
    val title: String,
    val description: String,
    val type: TaskType,
    val dueDate: String?
)

data class CreateActivityRequest(
    val description: String,
    val timestamp: String
)