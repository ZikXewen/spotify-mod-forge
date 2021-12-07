package zikxewen.spotify.events

import net.minecraft.client.Minecraft
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.event.TickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import zikxewen.spotify.SpotifyMod
import zikxewen.spotify.keybinds.Keybinds
import zikxewen.spotify.utils.SpotifyControls

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = SpotifyMod.ID, value = [Dist.CLIENT])
object InputEvents {
    @SubscribeEvent
    fun onKeyPress (event: InputEvent.KeyInputEvent) {
        val mc = Minecraft.getInstance()
        if (mc.level == null || SpotifyControls.cooldown > 0) return
        if(SpotifyControls.accessToken.isEmpty()){
            if(Keybinds.loginKey.isDown) SpotifyControls.login()
        } else {
            if(Keybinds.playPauseKey.isDown) SpotifyControls.playPause()
            if(Keybinds.nextSongKey.isDown) SpotifyControls.skip(true)
            if(Keybinds.prevSongKey.isDown) SpotifyControls.skip(false)
        }
    }
    @SubscribeEvent
    fun onTick (event: TickEvent.ClientTickEvent) {
        if(SpotifyControls.cooldown > 0) --SpotifyControls.cooldown;
    }
}