package dev.sunabak0.akiyadego.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Application controller
 *
 */
@RestController
class ApplicationController {
    /**
     * Top
     *
     */
    @GetMapping("/top")
    fun top (): ResponseEntity<String> {
        return ResponseEntity("top", HttpStatus.OK)
    }
}