package lenny.taskmanagementsystem.presentation

import lenny.taskmanagementsystem.application.query.GetAllProjectsUseCase
import lenny.taskmanagementsystem.application.query.GetProjectByIdUseCase
import org.springframework.web.bind.annotation.*

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
}