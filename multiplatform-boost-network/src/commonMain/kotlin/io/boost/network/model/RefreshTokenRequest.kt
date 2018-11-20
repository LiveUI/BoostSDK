package io.boost.network.model

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

/**
 * {
 * "token": "2018-01-10T18:38:35.762Z"
 * }
 */
@Serializable
data class RefreshTokenRequest(@Optional val token: String? = null)