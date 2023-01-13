package dev.sunabak0.akiyadego.presentation

import dev.sunabak0.akiyadego.openapi.generated.controller.DefaultApi
import dev.sunabak0.akiyadego.openapi.generated.model.Post
import dev.sunabak0.akiyadego.openapi.generated.model.PostResponse
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

    override fun allPost(): ResponseEntity<PostResponse> {
        return ResponseEntity(
            PostResponse(
                posts = listOf(
                    Post(
                        id = 1,
                        imagePath = "",
                        title = "",
                        category = "",
                        prefecture = "",
                        description = "",
                        userId = "",
                        createdAt = ""
                    ),
                )
            ),
            HttpStatus.OK
        )
    }
}
