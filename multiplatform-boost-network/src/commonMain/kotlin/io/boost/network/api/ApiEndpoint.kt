package io.boost.network.api

object ApiEndpoint {

    const val AUTH = "auth"
    const val APPS = "apps"
    const val APPS_ID = "apps/{id}"
    const val APPS_OVERVIEW = "apps/overview"
    const val KEYS = "keys"
    const val KEYS_ID = "keys/{id}"
    const val TEAMS = "teams"
    const val TEAMS_CHECK = "teams/check"
    const val TEAMS_TEAMID = "teams/{teamId}"
    const val TEAMS_TEAMID_USERS = "teams/{teamId}/users"
    const val TEAMS_TEAMID_LINK = "teams/{teamId}/link"
    const val TEAMS_TEAMID_UNLINK = "teams/{teamId}/unlink"
    const val TEAMS_TEAMID_KEYS = "teams/{teamId}/keys"
    const val TEAMS_TEAMID_APPS_OVERVIEW = "teams/{teamId}/apps/overview"
    const val TEAMS_TEAMID_APPS_INFO = "teams/{teamId}/apps/info"
    const val TOKEN = "token"
    const val SETTINGS = "settings"
    const val SETTINGS_ID = "settings/{id}"
    const val USERS = "users"
    const val USERS_GLOBAL = "users/global"
    const val APPS_ID_AUTH = "apps/{id}/auth"
    const val PING = "ping"
    const val INFO = "info"
    const val TEAPOT = "teapot"
}