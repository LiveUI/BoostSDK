package io.boost.network.model

import kotlinx.serialization.Serializable

/**
 * {
 * "username": "admin@liveui.io"
 * "password": "s3cretPassw0rd"
 * }
 */
@Serializable
data class AuthRequest(val email: String, val password: String)