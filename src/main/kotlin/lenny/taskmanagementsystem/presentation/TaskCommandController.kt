package lenny.taskmanagementsystem.presentation


import lenny.taskmanagementsystem.application.command.CreateTaskUseCase
import lenny.taskmanagementsystem.application.command.DeleteTaskUseCase
import lenny.taskmanagementsystem.application.command.UpdateTaskDetailsUseCase
import lenny.taskmanagementsystem.application.command.UpdateTaskStatusUseCase
import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.model.TaskType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/commands/tasks")
class TaskCommandController(
    private val createTaskUseCase: CreateTaskUseCase,
    private val updateTaskStatusUseCase: UpdateTaskStatusUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val updateTaskDetailsUseCase: UpdateTaskDetailsUseCase
) {

    @PostMapping
    fun createTask(@RequestBody request: CreateTaskRequest) =
        createTaskUseCase.execute(
            title = request.title,
            description = request.description,
            type = request.type,
            dueDate = request.dueDate
        )

    @PatchMapping("/{id}/status")
    fun updateStatus(
        @PathVariable id: String,
        @RequestParam status: TaskStatus
    ) {
        updateTaskStatusUseCase.execute(id, status)
    }

    @PutMapping("/{id}")
    fun updateTask(
        @PathVariable id: String,
        @RequestBody request: UpdateTaskRequest
    ) {
        updateTaskDetailsUseCase.execute(
            id,
            request.title,
            request.description,
            request.type,
            request.dueDate
        )
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: String) {
        deleteTaskUseCase.execute(id)
    }
}

data class CreateTaskRequest(
    val title: String,
    val description: String,
    val type: TaskType,
    val dueDate: String?
)

data class UpdateTaskRequest(
    val title: String,
    val description: String,
    val type: TaskType,
    val dueDate: String?
)