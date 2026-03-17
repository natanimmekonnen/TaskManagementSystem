package lenny.taskmanagementsystem.infrastructure

import lenny.taskmanagementsystem.domain.model.Task
import lenny.taskmanagementsystem.domain.model.TaskPriority
import lenny.taskmanagementsystem.domain.model.TaskStatus
import lenny.taskmanagementsystem.domain.model.TaskType
import lenny.taskmanagementsystem.domain.repository.TaskRepository
import org.springframework.stereotype.Repository

@Repository
class TaskRepositoryAdapter(
    private val mongoRepository: SpringDataTaskMongoRepository
) : TaskRepository {

    override fun save(task: Task): Task {
        return mongoRepository.save(task.toDocument()).toDomain()
    }

    override fun update(task: Task): Task {
        return mongoRepository.save(task.toDocument()).toDomain()
    }

    override fun deleteById(id: String) {
        mongoRepository.deleteById(id)
    }

    override fun findById(id: String): Task? {
        return mongoRepository.findById(id).orElse(null)?.toDomain()
    }

    override fun findAll(): List<Task> {
        return mongoRepository.findAll().map { it.toDomain() }
    }

    override fun findByStatus(status: TaskStatus): List<Task> {
        return mongoRepository.findByStatus(status.name).map { it.toDomain() }
    }
}
private fun Task.toDocument(): TaskDocument =
    TaskDocument(
        id = id,
        title = title,
        description = description,
        type = type.name,
        priority = priority.name,
        status = status.name,
        dueDate = dueDate,
        projectId = projectId,
    )

private fun TaskDocument.toDomain(): Task =
    Task(
        id = id,
        title = title,
        description = description,
        type = TaskType.valueOf(type),
        priority = TaskPriority.valueOf(priority),
        status = TaskStatus.valueOf(status),
        dueDate = dueDate,
        projectId = projectId,
    )