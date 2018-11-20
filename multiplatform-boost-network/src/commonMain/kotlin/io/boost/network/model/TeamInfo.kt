package io.boost.network.model

import kotlinx.serialization.Serializable

/**
 * Created by Vojtech Hrdina on 24/04/2018.
 */
@Serializable
data class TeamInfo(val teamId: String, val apps: Int, val builds: Int)