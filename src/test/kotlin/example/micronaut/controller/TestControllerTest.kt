package example.micronaut.controller

import example.micronaut.db.repository.TestRepository
import example.micronaut.db.repository.impl.TestRepositoryImpl
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.AbstractAnnotationSpec
import io.kotlintest.specs.StringSpec
import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpRequest.POST
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.mockk.mockk
import io.mockk.spyk

@MicronautTest
@Property(name = "foo.bar", value = "3")
class KotlinJUnit5Test(@Value("\${foo.bar}") private val value: Int,
                       @Property(name = "foo.bar") private val property: Int,
                       @Client("/test") private val client: RxHttpClient,
                       testRepository: TestRepository
) : StringSpec({


    @AbstractAnnotationSpec.Before
    fun before() {
        testRepository.deleteAll()

    }

    "test the values are injected"() {
        value shouldBe 3
        property shouldBe 3
        testRepository shouldNotBe null
    }

    "test compute num to square" {
        client shouldNotBe null
        val result = client.toBlocking().exchange(POST("/hello", ""), String::class.java)
        result shouldNotBe null
        result.code() shouldNotBe null
        result.code() shouldBe 201

    }
}) {
    @MockBean(TestRepositoryImpl::class) // <1>
    fun mathService(): TestRepository {
        return spyk()
    }
}