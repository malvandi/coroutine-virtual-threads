package ir.rahgozin.web.repository

import ir.rahgozin.web.entity.Person
import kotlinx.coroutines.flow.Flow
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CoroutineCrudRepository<Person, String> {

    @Query("{ 'name': ?0 }")
    fun findByName(name: String): Flow<Person>

    suspend fun findTopByFirstName(firsName: String): Person?
}