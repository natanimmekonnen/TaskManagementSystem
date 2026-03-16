package lenny.taskmanagementsystem.domain.repository

import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskStatus

interface TaskRepository {
    fun save(task: Task): Task

    fun update(task: Task): Task

    fun deleteById(id: String)

    fun findById(id: String): Task?

    fun findAll(): List<Task>

    fun findByStatus(status: TaskStatus): List<Task>
}