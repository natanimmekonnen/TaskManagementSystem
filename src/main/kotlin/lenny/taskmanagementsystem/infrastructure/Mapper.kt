package lenny.taskmanagementsystem.infrastructure

import lenny.taskmanagementsystem.domain.model.Activity
import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.model.Task

object ProjectMapper {

    fun toDocument(project: Project): ProjectDocument =
        ProjectDocument(
            id = project.id,
            name = project.name,
            description = project.description,
            tasks = project.tasks.map { toDocument(it) }
        )

    fun toDomain(document: ProjectDocument): Project =
        Project(
            id = document.id,
            name = document.name,
            description = document.description,
            tasks = document.tasks.map { toDomain(it) }
        )

    private fun toDocument(task: Task): TaskDocument =
        TaskDocument(
            id = task.id,
            title = task.title,
            description = task.description,
            status = task.status,
            type = task.type,
            priority = task.priority,
            dueDate = task.dueDate,
            activities = task.activities.map { toDocument(it) }
        )

    private fun toDomain(task: TaskDocument): Task =
        Task(
            id = task.id,
            title = task.title,
            description = task.description,
            status = task.status,
            type = task.type,
            priority = task.priority,
            dueDate = task.dueDate,
            activities = task.activities.map { toDomain(it) }
        )

    private fun toDocument(activity: Activity): ActivityDocument =
        ActivityDocument(
            id = activity.id,
            description = activity.description,
            timestamp = activity.timestamp
        )

    private fun toDomain(activity: ActivityDocument): Activity =
        Activity(
            id = activity.id,
            description = activity.description,
            timestamp = activity.timestamp
        )
}