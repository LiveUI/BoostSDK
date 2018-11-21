package io.boost.network.api

import io.boost.network.ApplicationDispatcher
import io.boost.network.Config
import io.boost.network.Session
import io.boost.network.interceptor.JwtAuth
import io.boost.network.model.*
import io.boost.network.util.*
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

internal class ApiRepositoryImpl(var config: Config) : ApiRepository {

    private val networkSession = Session

    private val client = HttpClient {
        expectSuccess = false
        install(JsonFeature) {
            serializer = KSerializer.serializer
        }
        install(JwtAuth) {
            session = networkSession
        }
    }

    override fun getBaseUrl(): String = config.url

    override suspend fun filter(
        url: String,
        filter: Filter
    ): Response<List<App>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.APPS,
            query = *arrayOf(
                Pair("name", filter.name),
                Pair("info", filter.info),
                Pair("platform", filter.platform),
                Pair("identifier", filter.identifier),
                Pair("build", filter.build),
                Pair("version", filter.version),
                Pair("limit", filter.limit),
                Pair("page", filter.page)
            )
        )
    }

    override suspend fun upload(url: String, tags: Tags): Response<App> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.APPS,
            query = *arrayOf(Pair("tags", tags.getTagSequence()))
        )

    }

    override suspend fun getApps(url: String): Response<List<App>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.APPS
        )
    }

    override suspend fun getApp(url: String, id: String): Response<App> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.APPS_ID,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun updateApp(url: String, id: String, app: App): Response<App> {
        return client.put(
            url = url,
            endpoint = ApiEndpoint.APPS_ID,
            query = *arrayOf(Pair("id", id)),
            requestBody = app
        )
    }

    override suspend fun deleteApp(url: String, id: String): Response<App> {
        return client.delete(
            url = url,
            endpoint = ApiEndpoint.APPS_ID,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun appsOverview(url: String): Response<List<AppOverview>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.APPS_OVERVIEW
        )
    }

    override suspend fun getUploadTokensForUser(url: String): Response<List<User>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.KEYS
        )
    }

    override suspend fun getUploadKey(url: String, id: String): Response<List<User>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.KEYS_ID,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun updateUploadKey(url: String, id: String): Response<List<User>> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.KEYS_ID,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun deleteUploadKey(url: String, id: String): Response<List<User>> {
        return client.delete(
            url = url,
            endpoint = ApiEndpoint.KEYS_ID,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun getTeams(url: String): Response<List<Team>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.TEAMS
        )
    }

    override suspend fun createTeam(url: String, team: CreateTeamRequest): Response<Team> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.TEAMS,
            requestBody = team
        )
    }

    override suspend fun checkTeam(url: String, team: TeamCheckRequest): Response<TeamCheck> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.TEAMS_CHECK,
            requestBody = team
        )
    }

    override suspend fun getTeam(url: String, teamId: String): Response<Team> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID,
            query = *arrayOf(Pair("teamId", teamId))
        )
    }

    override suspend fun updateTeam(url: String, teamId: String, team: Team): Response<Team> {
        return client.put(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID,
            query = *arrayOf(Pair("teamId", teamId)),
            requestBody = team
        )
    }

    override suspend fun getTeamUsers(url: String, teamId: String): Response<List<User>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID_USERS,
            query = *arrayOf(Pair("teamId", teamId))
        )
    }

    override suspend fun addUserToTeam(url: String, teamId: String, user: User): Response<Empty> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID_LINK,
            query = *arrayOf(Pair("teamId", teamId)),
            requestBody = user
        )
    }

    override suspend fun removeUserFromTeam(url: String, teamId: String, user: User): Response<Empty> {
        return client.delete(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID_UNLINK,
            query = *arrayOf(Pair("teamId", teamId)),
            requestBody = user
        )
    }

    override suspend fun getUploadTokensForTeam(url: String, teamId: String): Response<List<Team>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID_KEYS,
            query = *arrayOf(Pair("teamId", teamId))
        )
    }

    override suspend fun createUploadTokenInTeam(url: String, teamId: String, team: Team): Response<Team> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID_KEYS,
            query = *arrayOf(Pair("teamId", teamId)),
            requestBody = team
        )
    }

    override suspend fun teamAppsOverview(url: String, teamId: String): Response<List<AppOverview>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID_APPS_OVERVIEW,
            query = *arrayOf(Pair("teamId", teamId))
        )
    }

    override suspend fun getTeamInfo(url: String, teamId: String): Response<TeamInfo> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.TEAMS_TEAMID_APPS_INFO,
            query = *arrayOf(Pair("teamId", teamId))
        )
    }

    override suspend fun getSettings(url: String): Response<List<Settings>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.SETTINGS
        )
    }

    override suspend fun addSettings(url: String, id: String): Response<Settings> {
        return client.put(
            url = url,
            endpoint = ApiEndpoint.SETTINGS_ID,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun deleteSettings(url: String, id: String): Response<Settings> {
        return client.delete(
            url = url,
            endpoint = ApiEndpoint.SETTINGS_ID,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun getUsers(url: String): Response<List<User>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.USERS
        )
    }

    override suspend fun getUsersGlobal(url: String): Response<List<User>> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.USERS_GLOBAL
        )
    }

    override suspend fun getDownloadToken(url: String, id: String): Response<AppDownloadToken> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.APPS_ID_AUTH,
            query = *arrayOf(Pair("id", id))
        )
    }

    override suspend fun ping(url: String): Response<Message> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.PING
        )
    }

    override suspend fun teapot(url: String): Response<Message> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.TEAPOT
        )
    }

    override suspend fun getInfo(url: String): Response<ServerInfo> {
        return client.get(
            url = url,
            endpoint = ApiEndpoint.INFO
        )
    }

    override suspend fun registerUser(url: String, user: RegisterUser): Response<User> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.USERS,
            requestBody = user
        )
    }

    override suspend fun auth(url: String, auth: AuthRequest): Response<AuthResponse> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.AUTH,
            requestBody = auth
        )
    }

    override suspend fun refreshToken(url: String, token: RefreshTokenRequest): Response<RefreshTokenResponse> {
        return client.post(
            url = url,
            endpoint = ApiEndpoint.TOKEN,
            requestBody = token
        )
    }

}