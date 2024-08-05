package ir.rahgozin.web.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Person(
    @Id val id: String? = null,
    val username: String = "",
    var firstName: String = "",
    var lastName: String = ""
)
