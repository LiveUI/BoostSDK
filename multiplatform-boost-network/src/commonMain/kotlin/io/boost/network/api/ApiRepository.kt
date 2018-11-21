package io.boost.network.api

import io.boost.network.model.*

internal interface ApiRepository {

    fun getBaseUrl(): String

    suspend fun addSettings(url: String = getBaseUrl(), id: String): Response<Settings>

    suspend fun addUserToTeam(url: String = getBaseUrl(), teamId: String, user: User): Response<Empty>

    suspend fun appsOverview(url: String = getBaseUrl()): Response<List<AppOverview>>

    suspend fun auth(url: String = getBaseUrl(), auth: AuthRequest): Response<AuthResponse>

    suspend fun checkTeam(url: String = getBaseUrl(), team: TeamCheckRequest): Response<TeamCheck>

    suspend fun createTeam(url: String = getBaseUrl(), team: CreateTeamRequest): Response<Team>

    suspend fun createUploadTokenInTeam(url: String = getBaseUrl(), teamId: String, team: Team): Response<Team>

    suspend fun deleteApp(url: String = getBaseUrl(), id: String): Response<App>

    suspend fun deleteSettings(url: String = getBaseUrl(), id: String): Response<Settings>

    suspend fun deleteUploadKey(url: String = getBaseUrl(), id: String): Response<List<User>>

    suspend fun filter(url: String = getBaseUrl(), filter: Filter): Response<List<App>>

    suspend fun getApp(url: String = getBaseUrl(), id: String): Response<App>

    suspend fun getApps(url: String = getBaseUrl()): Response<List<App>>

    suspend fun getDownloadToken(url: String = getBaseUrl(), id: String): Response<AppDownloadToken>

    suspend fun getInfo(url: String = getBaseUrl()): Response<ServerInfo>

    suspend fun getSettings(url: String = getBaseUrl()): Response<List<Settings>>

    suspend fun getTeam(url: String = getBaseUrl(), teamId: String): Response<Team>

    suspend fun getTeamInfo(url: String = getBaseUrl(), teamId: String): Response<TeamInfo>

    suspend fun getTeams(url: String = getBaseUrl()): Response<List<Team>>

    suspend fun getTeamUsers(url: String = getBaseUrl(), teamId: String): Response<List<User>>

    suspend fun getUploadKey(url: String = getBaseUrl(), id: String): Response<List<User>>

    suspend fun getUploadTokensForTeam(url: String = getBaseUrl(), teamId: String): Response<List<Team>>

    suspend fun getUploadTokensForUser(url: String = getBaseUrl()): Response<List<User>>

    suspend fun getUsers(url: String = getBaseUrl()): Response<List<User>>

    suspend fun getUsersGlobal(url: String = getBaseUrl()): Response<List<User>>

    suspend fun ping(url: String = getBaseUrl()): Response<Message>

    suspend fun refreshToken(url: String = getBaseUrl(), token: RefreshTokenRequest): Response<RefreshTokenResponse>

    suspend fun registerUser(url: String = getBaseUrl(), user: RegisterUser): Response<User>

    suspend fun removeUserFromTeam(url: String = getBaseUrl(), teamId: String, user: User): Response<Empty>

    suspend fun teamAppsOverview(url: String = getBaseUrl(), teamId: String): Response<List<AppOverview>>

    suspend fun teapot(url: String = getBaseUrl()): Response<Message>

    suspend fun updateApp(url: String = getBaseUrl(), id: String, app: App): Response<App>

    suspend fun updateTeam(url: String = getBaseUrl(), teamId: String, team: Team): Response<Team>

    suspend fun updateUploadKey(url: String = getBaseUrl(), id: String): Response<List<User>>

    suspend fun upload(url: String = getBaseUrl(), tags: Tags): Response<App>

}