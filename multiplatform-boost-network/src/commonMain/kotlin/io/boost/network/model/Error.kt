package io.boost.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Error(val error: String, val description: String)