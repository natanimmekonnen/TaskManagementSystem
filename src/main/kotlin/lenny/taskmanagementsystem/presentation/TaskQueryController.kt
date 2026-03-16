package lenny.taskmanagementsystem.presentation

import lenny.taskmanagementsystem.application.query.GetAllTasksUseCase
import lenny.taskmanagementsystem.application.query.GetTaskByIdUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/queries/tasks")
class TaskQueryController {

    private val getAllTasksUseCase: GetAllTasksUseCase
    private val getTaskByIdUseCase: GetTaskByIdUseCase

    constructor(getAllTasksUseCase: GetAllTasksUseCase, getTaskByIdUseCase: GetTaskByIdUseCase) {
        this.getAllTasksUseCase = getAllTasksUseCase
        this.getTaskByIdUseCase = getTaskByIdUseCase
    }

    @GetMapping
    fun getAllTasks() =
        getAllTasksUseCase.execute()

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: String) =
        getTaskByIdUseCase.execute(id)
}