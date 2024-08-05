package ir.rahgozin.web.controller

import ir.rahgozin.web.entity.Person
import ir.rahgozin.web.service.PersonFakerService
import ir.rahgozin.web.service.PersonService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController @Autowired constructor(
    private val service: PersonService,
    private val fakerService: PersonFakerService
) {

    @PostMapping("/generate/persons/{count}")
    suspend fun generateFakePersons(@PathVariable count: Int) {
        fakerService.generateFake(count)
    }

    @GetMapping("/person")
    suspend fun getPersonByRandomName(): Person? {
        val fakeName = fakerService.getFakeName()
        return service.findTopByFirstname(fakeName.firstName())
    }

    @PostMapping("/person")
    suspend fun save(@RequestBody person: Person): Person = service.save(person)

    @GetMapping("/persons")
    suspend fun find(): Flow<Person> {
        return service.findAll()
    }
}