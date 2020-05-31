package example.micronaut.db.listener

import example.micronaut.db.entity.Test
import javax.persistence.PostPersist
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

class TestIdListener {
    @PostPersist
    fun testPostPersist1(test: Test) {
        try {

            println("___________________\n${test.id}")
        } catch (e: Exception) {
            e.printStackTrace();
        }
    }

}
