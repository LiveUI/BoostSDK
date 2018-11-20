package io.boost.network.model

import kotlinx.serialization.Serializable

/**
 * {
 * "id": "630C97E6-AC56-4213-882B-3BEBAE50BF6D",
 * "lastname": "Admin",
 * "registered": 541114427,
 * "su": true,
 * "email": "admin@liveui.io",
 * "firstname": "Super",
 * "disabled": false
 * }
 */
@Serializable
data class User(
    val id: String,
    val username: String,
    val firstname: String,
    val lastname: String,
    val registered: String,
    val avatar: String?,
    val email: String?,
    val su: Boolean,
    val disabled: Boolean)