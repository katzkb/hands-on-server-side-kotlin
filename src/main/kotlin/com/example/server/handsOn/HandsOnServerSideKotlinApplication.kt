package com.example.server.handsOn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@Suppress("UndocumentedPublicClass")
@SpringBootApplication
class HandsOnServerSideKotlinApplication

@Suppress("UndocumentedPublicFunction")
fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<HandsOnServerSideKotlinApplication>(*args)
}
