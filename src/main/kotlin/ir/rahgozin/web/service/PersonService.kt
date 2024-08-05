package ir.rahgozin.web.service

import ir.rahgozin.web.entity.Person
import ir.rahgozin.web.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService @Autowired constructor(val repository: PersonRepository) {

    suspend fun save(person: Person): Person = repository.save(person)

    suspend fun findTopByFirstname(firstName: String): Person? {
        return repository.findTopByFirstName(firstName)
    }

    suspend fun findAll(): Flow<Person> = repository.findAll()
}