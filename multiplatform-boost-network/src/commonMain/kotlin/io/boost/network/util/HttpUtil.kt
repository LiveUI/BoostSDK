package io.boost.network.util

import io.boost.network.model.Error
import io.boost.network.model.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.typeInfo
import io.ktor.client.features.json.defaultSerializer
import io.ktor.client.request.*
import io.ktor.client.response.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.http.URLBuilder
import io.ktor.http.contentType
import io.ktor.util.toMap

fun HttpRequestBuilder.parameter(value: Pair<String, Any?>?): Unit =
    value?.let { pair ->
        pair.second?.let {
            url.parameters.append(pair.first, it.toString())
        }
    } ?: Unit

fun URLBuilder.path(pathSegment: String, pathKey: String, param: Any) =
    path(pathSegment.replace("{$pathKey}", param.toString()))

fun buildUrl(
    url: String,
    endpoint: String,
    pathKey: String? = null,
    param: Any? = null
): String {
    return URLBuilder(urlString = url).apply {
        pathKey?.let { key ->
            param?.let { value ->
                path(endpoint, key, value)
            }
        } ?: path(endpoint)
    }.buildString()
}

suspend inline fun <reified T> processResponse(
    result: HttpResponse
): Response<T> {
    val responseCode = result.status
    val headers = result.headers.toMap()

    return if (responseCode == OK) {
        try {
            val data = defaultSerializer().read(typeInfo<T>(), result) as? T
            Response(
                result = data,
                headers = headers,
                responseCode = responseCode.value
            )
        } catch (e: Exception) {
            Response<T>(
                headers = headers,
                responseCode = responseCode.value,
                exception = e
            )
        }
    } else {
        try {
            Response<T>(
                headers = headers,
                responseCode = responseCode.value,
                error = defaultSerializer().read(typeInfo<Error>(), result) as? Error
            )
        } catch (e: Exception) {
            Response<T>(
                headers = headers,
                responseCode = responseCode.value,
                exception = e
            )
        }
    }
}

suspend inline fun <reified T> HttpClient.get(
    url: String,
    endpoint: String,
    pathKey: String? = null,
    param: Any? = null,
    vararg query: Pair<String, Any?>?
): Response<T> {
    val requestUrl = buildUrl(url, endpoint, pathKey, param)
    val response = get<HttpResponse>(requestUrl) {
        query.forEach {
            parameter(it)
        }
    }

    return processResponse(response)
}

suspend inline fun <reified T> HttpClient.post(
    url: String,
    endpoint: String,
    pathKey: String? = null,
    param: Any? = null,
    vararg query: Pair<String, Any?>?,
    requestBody: Any? = null
): Response<T> {
    val requestUrl = buildUrl(url, endpoint, pathKey, param)
    val response = post<HttpResponse>(requestUrl) {
        query.forEach {
            parameter(it)
        }
        requestBody?.let {
            contentType(ContentType.Application.Json)
            body = it
        }
    }

    return processResponse(response)
}

suspend inline fun <reified T> HttpClient.delete(
    url: String,
    endpoint: String,
    pathKey: String? = null,
    param: Any? = null,
    vararg query: Pair<String, Any?>?,
    requestBody: Any? = null
): Response<T> {
    val requestUrl = buildUrl(url, endpoint, pathKey, param)
    val response = delete<HttpResponse>(requestUrl) {
        query.forEach {
            parameter(it)
        }
        requestBody?.let {
            contentType(ContentType.Application.Json)
            body = it
        }
    }

    return processResponse(response)
}

suspend inline fun <reified T> HttpClient.put(
    url: String,
    endpoint: String,
    pathKey: String? = null,
    param: Any? = null,
    vararg query: Pair<String, Any?>?,
    requestBody: Any? = null
): Response<T> {
    val requestUrl = buildUrl(url, endpoint, pathKey, param)
    val response = put<HttpResponse>(requestUrl) {
        query.forEach {
            parameter(it)
        }
        requestBody?.let {
            contentType(ContentType.Application.Json)
            body = it
        }
    }

    return processResponse(response)
}