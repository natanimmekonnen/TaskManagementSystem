package lenny.taskmanagementsystem.presentation

import lenny.taskmanagementsystem.application.command.CreateProject
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/commands/projects")
class ProjectCommandController(
    private val createProject: CreateProject
) {

    @PostMapping
    fun createProject(@RequestBody request: CreateProjectRequest) =
        createProject.execute(
            name = request.name,
            description = request.description
        )
}

data class CreateProjectRequest(
    val name: String,
    val description: String
)