package dev.sunabak0.akiyadego.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    @Test
    fun `ユーザの名前の文字数が違反していたユーザの生成に失敗する`() {
        /**
         * given:
         */

        /**
         * when:
         */

        /**
         * then:
         * - 名前を検査
         */
        val user = assertThrows<IllegalArgumentException> {
            User.new(1, "uuid", "", "sample@com", "password", "20230123-12:00:00", listOf())
        }
        assertEquals(user.message, "名前が入力されていません")
    }
}
