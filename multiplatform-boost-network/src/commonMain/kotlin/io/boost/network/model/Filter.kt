package io.boost.network.model

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
class Filter(
    @Optional var name: String? = null,
    @Optional var info: String? = null,
    @Optional var platform: String? = null,
    @Optional var identifier: String? = null,
    @Optional var build: Int? = null,
    @Optional var version: String? = null,
    @Optional var limit: Int? = null,
    @Optional var page: Int? = null)