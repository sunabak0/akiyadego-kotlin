package dev.sunabak0.akiyadego

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Akiyadego application
 *
 * @constructor Create empty Akiyadego application
 */
@SpringBootApplication
class AkiyadegoApplication

/**
 * Main
 *
 * @param args
 */
fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<AkiyadegoApplication>(*args)
}
