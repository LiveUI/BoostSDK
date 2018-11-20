package io.boost.network.model

import kotlinx.serialization.Serializable

@Serializable
class Tags(var tags: List<String>) {

    fun getTagSequence(): String {
        return tags.joinToString(separator = ",")
    }
}