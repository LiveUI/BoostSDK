package io.boost.network.model

import kotlinx.serialization.Optional
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
class User(
    @Optional val id: String? = null,
    @Optional val username: String? = null,
    @Optional val firstname: String? = null,
    @Optional val lastname: String? = null,
    @Optional val registered: String? = null,
    @Optional val avatar: String? = null,
    @Optional val email: String? = null,
    @Optional val su: Boolean? = null,
    @Optional val disabled: Boolean? = null)