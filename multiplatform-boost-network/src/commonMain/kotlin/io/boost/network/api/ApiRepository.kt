package io.boost.network.api

import io.boost.network.model.*

internal interface ApiRepository {

    suspend fun getApps(url: String = getBaseUrl()): Response<MutableList<App>>

    suspend fun getApp(url: String = getBaseUrl(), id: String): Response<App>

    suspend fun updateApp(url: String = getBaseUrl(), id: String, app: App): Response<App>

    suspend fun deleteApp(url: String = getBaseUrl(), id: String): Response<App>

    suspend fun appsOverview(url: String = getBaseUrl()): Response<MutableList<AppOverview>>

    suspend fun getUploadTokensForUser(url: String = getBaseUrl()): Response<MutableList<User>>

    suspend fun getUploadKey(url: String = getBaseUrl(), id: String): Response<MutableList<User>>

    suspend fun updateUploadKey(url: String = getBaseUrl(), id: String): Response<MutableList<User>>

    suspend fun deleteUploadKey(url: String = getBaseUrl(), id: String): Response<MutableList<User>>

    suspend fun getTeams(url: String = getBaseUrl()): Response<MutableList<Team>>

    suspend fun createTeam(url: String = getBaseUrl(), team: CreateTeamRequest): Response<Team>

    suspend fun checkTeam(url: String = getBaseUrl(), team: TeamCheckRequest): Response<TeamCheck>

    suspend fun getTeam(url: String = getBaseUrl(), teamId: String): Response<Team>

    suspend fun updateTeam(url: String = getBaseUrl(), teamId: String, team: Team): Response<Team>

    suspend fun getTeamUsers(url: String = getBaseUrl(), teamId: String): Response<MutableList<User>>

    suspend fun addUserToTeam(url: String = getBaseUrl(), teamId: String, user: User): Response<Empty>

    suspend fun removeUserFromTeam(url: String = getBaseUrl(), teamId: String, user: User): Response<Empty>

    suspend fun getUploadTokensForTeam(url: String = getBaseUrl(), teamId: String): Response<MutableList<Team>>

    suspend fun createUploadTokenInTeam(url: String = getBaseUrl(), teamId: String, team: Team): Response<Team>

    suspend fun teamAppsOverview(url: String = getBaseUrl(), teamId: String): Response<MutableList<AppOverview>>

    suspend fun getTeamInfo(url: String = getBaseUrl(), teamId: String): Response<TeamInfo>

    suspend fun getSettings(url: String = getBaseUrl()): Response<MutableList<Settings>>

    suspend fun addSettings(url: String = getBaseUrl(), id: String): Response<Settings>

    suspend fun deleteSettings(url: String = getBaseUrl(), id: String): Response<Settings>

    suspend fun getUsers(url: String = getBaseUrl()): Response<MutableList<User>>

    suspend fun getUsersGlobal(url: String = getBaseUrl()): Response<MutableList<User>>

    suspend fun registerUser(url: String = getBaseUrl(), user: RegisterUser): Response<User>

    suspend fun getDownloadToken(url: String = getBaseUrl(), id: String): Response<AppDownloadToken>

    suspend fun ping(url: String = getBaseUrl()): Response<Message>

    suspend fun teapot(url: String = getBaseUrl()): Response<Message>

    suspend fun getInfo(url: String = getBaseUrl()): Response<ServerInfo>

    fun getBaseUrl(): String

    suspend fun upload(url: String = getBaseUrl(), tags: Tags): Response<App>

    suspend fun filter(url: String = getBaseUrl(), filter: Filter): Response<MutableList<App>>

    suspend fun auth(url: String = getBaseUrl(), auth: AuthRequest): Response<AuthResponse>

    suspend fun refreshToken(url: String = getBaseUrl(), token: RefreshTokenRequest): Response<RefreshTokenResponse>
}