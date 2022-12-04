package dev.sunabak0.akiyadego

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AkiyadegoApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<AkiyadegoApplication>(*args)
}
