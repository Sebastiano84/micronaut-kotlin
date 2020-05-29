package example.micronaut.db.repository

import example.micronaut.db.entity.Test
import javax.validation.constraints.NotNull

interface TestRepository {
    fun save(@NotNull name: String)
    fun findAll(): List<Test>
}
