package lenny.taskmanagementsystem.domain.factory

import lenny.taskmanagementsystem.domain.model.Activity
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ActivityFactory {

    fun create(
        id: String,
        description: String,
        timestamp: String
    ): Activity {

        require(description.isNotEmpty()) { "description cannot be empty" }

        return Activity(
            id = UUID.randomUUID().toString(),
            description = description,
            timestamp = timestamp
        )
    }
}