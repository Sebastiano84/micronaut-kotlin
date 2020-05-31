package example.micronaut.db.repository.impl

import example.micronaut.db.entity.Test
import example.micronaut.db.repository.TestRepository
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.constraints.NotBlank

@Singleton
open class TestRepositoryImpl(@param:CurrentSession @field:PersistenceContext val entityManager: EntityManager) : TestRepository {
    @Transactional(readOnly = true)
    override fun findAll(): List<Test> = entityManager.createQuery("SELECT d FROM Test d").resultList as List<Test>


    @Transactional
    override fun save(name: @NotBlank String) {
        return entityManager.persist(Test(name))
    }

    @Transactional
    override fun deleteAll(): List<Object> {
        return entityManager.createQuery("delete FROM Test d where 1=1").resultList as List<Object>
    }
}