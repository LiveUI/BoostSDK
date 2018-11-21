package io.boost.network.api

import io.boost.network.ApplicationDispatcher
import io.boost.network.Config
import io.boost.network.model.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BoostApi(config: Config) {

    private val api: ApiRepository = ApiRepositoryImpl(config = config)

    fun addSettings(id: String, success: (Settings?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.addSettings(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }

    fun addUserToTeam(id: String, user: User, success: (Empty?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.addUserToTeam(teamId = id, user = user)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getAppsOverview(success: (List<AppOverview>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.appsOverview()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun auth(auth: AuthRequest, success: (AuthResponse?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.auth(auth = auth)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun checkTeam(team: TeamCheckRequest, success: (TeamCheck?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.checkTeam(team = team)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun createTeam(team: CreateTeamRequest, success: (Team?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.createTeam(team = team)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun createUploadTokenInTeam(team: Team, success: (Team?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.createUploadTokenInTeam(teamId = team.id, team = team)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun deleteApp(id: String, success: (App?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.deleteApp(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun deleteSettings(id: String, success: (Settings?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.deleteSettings(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun deleteUploadKey(id: String, success: (List<User>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.deleteUploadKey(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun filter(filter: Filter, success: (List<App>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.filter(filter = filter)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getApp(id: String, success: (App?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getApp(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getApps(id: String, success: (List<App>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getApps()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getDownloadToken(id: String, success: (AppDownloadToken?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getDownloadToken(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getServerInfo(id: String, success: (ServerInfo?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getInfo()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getSettings(success: (List<Settings>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getSettings()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getTeam(id: String, success: (Team?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getTeam(teamId = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getTeamInfo(id: String, success: (TeamInfo?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getTeamInfo(teamId = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getTeams(success: (List<Team>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getTeams()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getTeamUsers(id: String, success: (List<User>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getTeamUsers(teamId = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getUploadKey(id: String, success: (List<User>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getUploadKey(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getUploadTokensForTeam(id: String, success: (List<Team>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getUploadTokensForTeam(teamId = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getUploadTokensForUser(success: (List<User>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getUploadTokensForUser()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getUsers(success: (List<User>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getUsers()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun getUsersGlobal(success: (List<User>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.getUsersGlobal()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun ping(success: (Message?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.ping()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun refreshToken(token: RefreshTokenRequest, success: (RefreshTokenResponse?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.refreshToken(token = token)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun registerUser(user: RegisterUser, success: (User?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.registerUser(user = user)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }

    fun removeUserFromTeam(teamId: String, user: User, success: (Empty?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.removeUserFromTeam(teamId = teamId, user = user)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun teapot(id: String, success: (Message?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.teapot()
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun updateApp(id: String, app: App, success: (App?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.updateApp(id = id, app = app)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun updateTeam(teamId: String, team: Team, success: (Team?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.updateTeam(teamId = teamId, team = team)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun updateUploadKey(id: String, success: (List<User>?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.updateUploadKey(id = id)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
    fun upload(tags: Tags, success: (App?) -> Unit, error: (Error?) -> Unit = {}) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result = api.upload(tags = tags)
            if(result.responseCode == 200) {
                success(result.result)
            } else {
                error(result.error)
            }
        }
    }
}