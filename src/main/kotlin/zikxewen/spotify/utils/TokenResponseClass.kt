package zikxewen.spotify.utils

import kotlinx.serialization.Serializable

@Serializable
data class TokenResponseClass (
    val refreshToken: String,
    val accessToken: String = ""
)