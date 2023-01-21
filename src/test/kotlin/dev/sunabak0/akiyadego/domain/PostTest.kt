package dev.sunabak0.akiyadego.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PostTest {
    @Test
    fun `投稿のタイトルの文字数が違反していたら投稿の生成に失敗する`() {
        /**
         * given:
         */

        /**
         * when:
         * -
         */

        /**
         * then:
         * - タイトルを検査
         */
        val e = assertThrows<IllegalArgumentException> {
            Post.new(1, "/path", "", "akiya", "tokyo", "空き家の説明", 1, "20230117-12:00:00")
        }
        assertEquals(e.message, "タイトルが1文字未満です")
    }
}
