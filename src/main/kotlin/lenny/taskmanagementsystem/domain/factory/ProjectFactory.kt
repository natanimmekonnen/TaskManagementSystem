package lenny.taskmanagementsystem.domain.factory

import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.model.TaskType
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ProjectFactory  {
    fun create(
       id:String,
       name:String,
       description: String,
    ): Project {

        require(name.isNotEmpty()) { "name cannot be empty" }

        return Project(
            id = UUID.randomUUID().toString(),
            name = name,
            description = description,
        )

    }

}