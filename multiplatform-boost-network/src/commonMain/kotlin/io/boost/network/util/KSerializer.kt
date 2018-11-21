package io.boost.network.util

import io.boost.network.model.*
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.features.json.serializer.KotlinxSerializer

object KSerializer {
    val serializer: JsonSerializer = KotlinxSerializer().apply {
        setMapper(AuthRequest::class, AuthRequest.serializer())
        setMapper(AuthResponse::class, AuthResponse.serializer())
        setMapper(User::class, User.serializer())
        setMapper(App::class, App.serializer())
        setMapper(AppDownloadToken::class, AppDownloadToken.serializer())
        setMapper(AppOverview::class, AppOverview.serializer())
        setMapper(AuthRequest::class, AuthRequest.serializer())
        setMapper(CreateTeamRequest::class, CreateTeamRequest.serializer())
        setMapper(Empty::class, Empty.serializer())
        setMapper(Error::class, Error.serializer())
        setMapper(Filter::class, Filter.serializer())
        setMapper(Message::class, Message.serializer())
        setMapper(RefreshTokenRequest::class, RefreshTokenRequest.serializer())
        setMapper(RefreshTokenResponse::class, RefreshTokenResponse.serializer())
        setMapper(RegisterUser::class, RegisterUser.serializer())
        setMapper(ServerInfo::class, ServerInfo.serializer())
        setMapper(Settings::class, Settings.serializer())
        setMapper(Tags::class, Tags.serializer())
        setMapper(Team::class, Team.serializer())
        setMapper(TeamCheck::class, TeamCheck.serializer())
        setMapper(TeamCheckRequest::class, TeamCheckRequest.serializer())
        setMapper(TeamInfo::class, TeamInfo.serializer())
    }
}