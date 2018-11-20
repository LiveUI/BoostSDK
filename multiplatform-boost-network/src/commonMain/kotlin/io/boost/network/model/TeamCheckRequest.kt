package io.boost.network.model

import kotlinx.serialization.Serializable

@Serializable
data class TeamCheckRequest(val identifier: String)