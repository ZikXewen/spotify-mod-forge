package zikxewen.spotify

import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import zikxewen.spotify.config.Config

@Mod(SpotifyMod.ID)
object SpotifyMod {
    const val ID = "spotify"
    const val ENDPOINT = "https://spotify-mod-endpoint.vercel.app/api/"
    val logger: Logger = LogManager.getLogger(ID)
    init {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.spec, "spotify-client.toml")
    }
}