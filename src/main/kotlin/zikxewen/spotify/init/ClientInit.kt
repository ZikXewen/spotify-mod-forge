package zikxewen.spotify.init

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import zikxewen.spotify.SpotifyMod
import zikxewen.spotify.keybinds.Keybinds
import zikxewen.spotify.auth.AuthServer

@Mod.EventBusSubscriber(modid = SpotifyMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object ClientInit {
    @SubscribeEvent
    fun onClientSetup(event: FMLClientSetupEvent){
        AuthServer.register() // Might have to change to init soon
        Keybinds.register()
    }
}