package example.micronaut.db.listener

import example.micronaut.db.entity.Test
import javax.persistence.PostPersist

class TestIdListener {
    @PostPersist
    fun testPostPersist(test: Test) {
        try {
            println("${test.id}")
        } catch (e: Exception) {
            e.printStackTrace();
        }
    }
}
