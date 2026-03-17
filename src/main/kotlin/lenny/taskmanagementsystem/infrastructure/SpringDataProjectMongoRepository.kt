package lenny.taskmanagementsystem.infrastructure


import org.springframework.data.mongodb.repository.MongoRepository

interface SpringDataProjectMongoRepository : MongoRepository<ProjectDocument, String>