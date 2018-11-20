package io.boost.network.model

import kotlinx.serialization.Serializable

/**
 * Created by Vojtech Hrdina on 24/04/2018.
 */
@Serializable
data class Settings(val id:String, val name: String, val config: String)