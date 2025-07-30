package com.example.server.handsOn

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @GetMapping("/")
    public open fun helloWorld(): String {
        return "Hello World"
    }
}
