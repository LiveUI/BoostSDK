package io.boost.network.interceptor

import io.boost.network.Session
import io.ktor.client.HttpClient
import io.ktor.client.features.HttpClientFeature
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.client.response.HttpResponsePipeline
import io.ktor.http.HttpHeaders
import io.ktor.util.AttributeKey

class JwtAuth(val session: Session) {

    class Configuration {

        lateinit var session: Session

        internal fun build(): JwtAuth = JwtAuth(session)
    }

    companion object Feature : HttpClientFeature<Configuration, JwtAuth> {

        override val key: AttributeKey<JwtAuth> = AttributeKey("JwtAuthHeader")

        override fun prepare(block: Configuration.() -> Unit): JwtAuth = Configuration().apply(block).build()

        override fun install(feature: JwtAuth, scope: HttpClient) {
            scope.requestPipeline.intercept(HttpRequestPipeline.State) {
                if (feature.session.token == null) return@intercept
                feature.session.token?.let {
                    context.headers.append(HttpHeaders.Authorization, it)
                }
            }

            scope.responsePipeline.intercept(HttpResponsePipeline.Receive) {
                context.response.headers.getAll(HttpHeaders.Authorization)?.firstOrNull()?.let {
                    feature.session.token = it
                }
            }
        }
    }
}