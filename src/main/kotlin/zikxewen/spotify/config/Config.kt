package zikxewen.spotify.config

import net.minecraftforge.common.ForgeConfigSpec

object Config {
    private val builder = ForgeConfigSpec.Builder()
    val spec: ForgeConfigSpec
    val refreshToken: ForgeConfigSpec.ConfigValue<String>
    init {
        builder.push("Spotify Mod")
        refreshToken = builder.comment("Latest Spotify Refresh Token").define("Refresh Token", "")
        builder.pop()
        spec = builder.build()
    }
}