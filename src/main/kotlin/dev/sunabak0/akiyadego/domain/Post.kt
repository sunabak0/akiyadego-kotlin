package dev.sunabak0.akiyadego.domain

/**
 * 投稿
 *
 * @property id
 * @property imagePath
 * @property title
 * @property category
 * @property prefecture
 * @property description
 * @property userId
 * @property createdAt
 * @constructor Create empty Post
 */
data class Post(
    val id: Int,
    val imagePath: String,
    val title: String,
    val category: String,
    val prefecture: String,
    val description: String,
    val userId: Int,
    val createdAt: String,
) {
    /**
     * Factory メソッド
     */
    companion object {
        /**
         * Validation 有り
         */
        fun new(
            id: Int,
            imagePath: String,
            title: String,
            category: String,
            prefecture: String,
            description: String,
            userId: Int,
            createdAt: String,
        ): Post {
            if (title.isEmpty()) {
                return IllegalArgumentException("タイトルが1文字未満です")
            }
            return Post(id, imagePath, title, category, prefecture, description, userId, createdAt)
        }
    }
}
