package zikxewen.spotify.keybinds

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.ClientRegistry
import zikxewen.spotify.SpotifyMod

object Keybinds {
    val loginKey = keyBuilder("login", InputConstants.KEY_G)
    val nextSongKey = keyBuilder("next", InputConstants.KEY_APOSTROPHE)
    val prevSongKey = keyBuilder("prev", InputConstants.KEY_SEMICOLON)
    val playPauseKey = keyBuilder("play", InputConstants.KEY_P)
    fun register(){
        ClientRegistry.registerKeyBinding(loginKey);
        ClientRegistry.registerKeyBinding(nextSongKey);
        ClientRegistry.registerKeyBinding(prevSongKey);
        ClientRegistry.registerKeyBinding(playPauseKey)
    }
    private fun keyBuilder(name: String, key: Int) = KeyMapping("key." + SpotifyMod.ID + "." + name, key, "key.category." + SpotifyMod.ID)
}