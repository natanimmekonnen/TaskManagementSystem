package lenny.taskmanagementsystem.presentation

import lenny.taskmanagementsystem.application.query.GetAllProjectsUseCase
import lenny.taskmanagementsystem.application.query.GetProjectByIdUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/queries/projects")
class ProjectQueryController(
    private val getAllProjectsUseCase: GetAllProjectsUseCase,
    private val getProjectByIdUseCase: GetProjectByIdUseCase
) {

    @GetMapping
    fun getAllProjects() = getAllProjectsUseCase.execute()

    @GetMapping("/{id}")
    fun getProjectById(@PathVariable id: String) =
        getProjectByIdUseCase.execute(id)
    @GetMapping("/{id}/tasks")
    fun getTasks(@PathVariable id: String) =
        getProjectByIdUseCase.execute(id)?.tasks ?: emptyList()
}