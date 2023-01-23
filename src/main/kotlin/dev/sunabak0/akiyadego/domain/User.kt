package dev.sunabak0.akiyadego.domain

import dev.sunabak0.akiyadego.openapi.generated.model.Post

/**
 * ユーザ
 *
 * @property id
 * @property uuid
 * @property name
 * @property email
 * @property password
 * @property createdAt
 * @property posts
 * @constructor Create empty User
 */
data class User(
    val id: Int,
    val uuid: String,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: String,
    val posts: List<Post>,
) {
    /**
     *  Factoryメソッド
     */
    companion object {
        /**
         * Validation 有り
         *
         */
        fun new(
            id: Int,
            uuid: String,
            name: String,
            email: String,
            password: String,
            createdAt: String,
            posts: List<Post>,
        ): Any {
            if (name.isEmpty()) {
                return IllegalArgumentException("名前が１文字未満です")
            }
            return User(id, uuid, name, email, password, createdAt, posts)
        }
    }
}
