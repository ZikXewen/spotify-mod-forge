package zikxewen.spotify.utils

import kotlinx.serialization.Serializable

@Serializable
data class PlaybackStatusClass(
    val is_playing: Boolean
)
