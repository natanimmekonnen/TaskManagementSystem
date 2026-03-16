package lenny.taskmanagementsystem.infrastructure

import org.springframework.data.mongodb.repository.MongoRepository

interface SpringDataTaskMongoRepository : MongoRepository<TaskDocument, String> {
    fun findByStatus(status: String): List<TaskDocument>
//    fun findByAssignedUser(assignedUser: String): List<TaskDocument>
}