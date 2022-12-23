package dev.sunabak0.akiyadego.presentation

import dev.sunabak0.akiyadego.openapi.generated.controller.DefaultApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Application controller
 *
 */
@RestController
class ApplicationController : DefaultApi {
    override fun rootGet(): ResponseEntity<Unit> {
        return ResponseEntity(Unit, HttpStatus.OK)
    }
}
