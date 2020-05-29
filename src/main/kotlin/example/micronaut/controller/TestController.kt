package example.micronaut.controller

import example.micronaut.db.entity.Test
import example.micronaut.db.repository.TestRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

@Controller("/test")
class TestController(val testRepository: TestRepository) {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(): List<Test> {
        return testRepository.findAll();
    }

    @Post("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun save(name: String) {
        testRepository.save(name)
    }

}