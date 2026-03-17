package lenny.taskmanagementsystem.infrastructure


import lenny.taskmanagementsystem.domain.model.Project
import lenny.taskmanagementsystem.domain.repository.ProjectRepository
import org.springframework.stereotype.Repository

@Repository
class ProjectRepositoryAdapter(
    private val mongoRepository: SpringDataProjectMongoRepository
) : ProjectRepository {

    override fun save(project: Project): Project {
        return mongoRepository.save(project.toDocument()).toDomain()
    }

    override fun findById(id: String): Project? {
        return mongoRepository.findById(id).orElse(null)?.toDomain()
    }

    override fun findAll(): List<Project> {
        return mongoRepository.findAll().map { it.toDomain() }
    }

    override fun deleById(id: String) {
        mongoRepository.deleteById(id)
    }


}
private fun Project.toDocument(): ProjectDocument =
    ProjectDocument(
        id = id,
        name = name,
        description = description
    )

private fun ProjectDocument.toDomain(): Project =
    Project(
        id = id,
        name = name,
        description = description
    )