package io.boost.network.impl

interface IApp {
    fun getAppId(): String
    fun getAppIdentifier(): String
    fun getAppVersion(): String
    fun getAppPlatform(): String
    fun getAppName(): String
    fun getAppBuild(): String
    fun hasIcon(): Boolean
}