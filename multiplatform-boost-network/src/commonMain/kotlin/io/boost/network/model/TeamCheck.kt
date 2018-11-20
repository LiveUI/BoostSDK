package io.boost.network.model

import kotlinx.serialization.Serializable

/**
 * {
 * "code": "ok"
 * "error": "Identifier is available",
 * "identifier": "my-new-team"
 * }
 */
@Serializable
data class TeamCheck(val code: String, val error: String, val identifier: String)