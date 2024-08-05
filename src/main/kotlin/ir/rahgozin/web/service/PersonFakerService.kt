package ir.rahgozin.web.service

import com.github.javafaker.Faker
import com.github.javafaker.Name
import ir.rahgozin.web.entity.Person
import ir.rahgozin.web.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonFakerService @Autowired constructor(private val repository: PersonRepository) {

    val faker = Faker()

    suspend fun generateFake(count: Int) {
        for (i in 1..count) {
            val fakeUser = getFakeName()
            val person = Person(null, fakeUser.username(), fakeUser.firstName(), fakeUser.lastName())
            repository.save(person)
        }
    }

    fun getFakeName(): Name {
        return faker.name()
    }
}