package lenny.taskmanagementsystem.domain.factory

import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.model.TaskType
import lenny.taskmanagementsystem.domain.model.Task
import org.springframework.stereotype.Component
import java.util.UUID
@Component
class TaskFactory  {
     fun create(
        title: String,
        description: String,
        type: TaskType,
        dueDate: String?,
    ): Task {

        require(title.isNotEmpty()) { "title cannot be empty" }
         val priority=when (type) {
             TaskType.PERSONAL->TaskPriority.LOW
             TaskType.WORK->TaskPriority.MEDIUM
             TaskType.URGENT->TaskPriority.HIGH
         }
        return Task(
            id = UUID.randomUUID().toString(),
            title = title,
            description = description,
            status = TaskStatus.TODO,
            dueDate = dueDate,
            priority = TaskPriority.LOW,
            type = type,
        )

    }

}