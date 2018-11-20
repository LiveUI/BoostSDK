package io.boost.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUser(val firstname: String, val lastname: String, val username: String, val email: String, val password: String)