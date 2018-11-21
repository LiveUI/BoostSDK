package io.boost.network.model


class Response<T>(val result: T? = null,
                  val headers: Map<String, List<String>>? = null,
                  val responseCode: Int? = null,
                  val error: Error? = null,
                  val exception: Exception? = null)