package zikxewen.spotify.utils

import net.minecraft.Util
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.TranslatableComponent
import zikxewen.spotify.SpotifyMod

object Messenger {
    private val player = Minecraft.getInstance().player
    fun send(message: String) {
        player!!.sendMessage(TranslatableComponent("message." + SpotifyMod.ID + "." + message), Util.NIL_UUID)
    }
}