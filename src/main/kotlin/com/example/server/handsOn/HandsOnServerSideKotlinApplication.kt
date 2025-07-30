package com.example.server.handsOn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HandsOnServerSideKotlinApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<HandsOnServerSideKotlinApplication>(*args)
}
