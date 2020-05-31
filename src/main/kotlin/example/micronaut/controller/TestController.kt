package example.micronaut.controller

import example.micronaut.db.entity.Test
import example.micronaut.db.repository.TestRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

@Controller("/test")
class TestController(val testRepository: TestRepository) {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): List<Test> {
        return testRepository.findAll();
    }

    @Post("/{name}")
    fun save(name: String): MutableHttpResponse<String>? {
        testRepository.save(name)
        return HttpResponse.created(name)

    }

}