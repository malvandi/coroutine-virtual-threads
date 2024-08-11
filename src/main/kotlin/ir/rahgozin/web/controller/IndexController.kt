package ir.rahgozin.web.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController @Autowired constructor(
    @Value("\${spring.threads.virtual.enabled}")
    private val virtualThreadEnabled: Boolean
) {

    @GetMapping("index")
    fun index(): Map<String, Any> {
        return mapOf(
            "author" to "Morteza Malvandi",
            "application" to "Virtual Threads",
            "version" to "1.0.0",
            "virtualThreads" to virtualThreadEnabled
        )
    }
}