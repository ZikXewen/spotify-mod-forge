package zikxewen.spotify.datagen

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent
import zikxewen.spotify.SpotifyMod

@Mod.EventBusSubscriber(modid = SpotifyMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent){
        val generator = event.generator
        if(event.includeClient()){
            generator.addProvider(Language(generator))
        }
    }
}