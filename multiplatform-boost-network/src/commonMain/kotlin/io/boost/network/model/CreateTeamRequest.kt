package io.boost.network.model

import kotlinx.serialization.Serializable

/**
 * {
 * "name": "Admin team",
 * "identifier": "admin-team"
 * }
 */
@Serializable
data class CreateTeamRequest(val name: String, val identifier: String)