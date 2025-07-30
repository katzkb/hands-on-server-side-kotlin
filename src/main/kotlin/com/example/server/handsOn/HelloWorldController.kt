package com.example.server.handsOn

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Suppress("UndocumentedPublicClass")
@RestController
class HelloWorldController {
    @Suppress("UndocumentedPublicFunction")
    @GetMapping("/")
    public open fun helloWorld(): String {
        return "Hello World"
    }
}
