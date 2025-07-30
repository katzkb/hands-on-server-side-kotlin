package com.example.server.crud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@Suppress("UndocumentedPublicClass")
@SpringBootApplication
class Application

@Suppress("UndocumentedPublicFunction")
fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<Application>(*args)
}
