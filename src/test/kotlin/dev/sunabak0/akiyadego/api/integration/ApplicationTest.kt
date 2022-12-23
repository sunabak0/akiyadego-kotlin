package dev.sunabak0.akiyadego.api.integration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTest(@Autowired val mockMvc: MockMvc) {
    @Test
    @DisplayName("GET / のテスト")
    fun rootGetTest() {
        /**
         * given:
         */

        /**
         * when:
         */
        val response = mockMvc.get("/") {
            contentType = MediaType.APPLICATION_JSON
        }.andReturn().response
        val actualStatus = response.status
        val actualResponseBody = response.contentAsString

        /**
         * then:
         */
        val expectedStatus = HttpStatus.OK.value()
        val expectedResponseBody = "{}"
        assertThat(actualStatus).isEqualTo(expectedStatus)
        assertThat(actualResponseBody).isEqualTo(expectedResponseBody)
    }
}
