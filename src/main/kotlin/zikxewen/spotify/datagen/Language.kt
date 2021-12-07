package zikxewen.spotify.datagen

import net.minecraft.data.DataGenerator
import net.minecraftforge.common.data.LanguageProvider
import zikxewen.spotify.SpotifyMod

class Language(gen: DataGenerator) : LanguageProvider(gen, SpotifyMod.ID, "en_us") {
    override fun addTranslations() {
        add("key.category." + SpotifyMod.ID, "Spotify Mod")
        add("key." + SpotifyMod.ID + ".login", "Spotify Login")
        add("key." + SpotifyMod.ID + ".play", "Play/Pause")
        add("key." + SpotifyMod.ID + ".prev", "Previous")
        add("key." + SpotifyMod.ID + ".next", "Next")
        add("message." + SpotifyMod.ID + ".play", "Playing...")
        add("message." + SpotifyMod.ID + ".pause", "Paused")
        add("message." + SpotifyMod.ID + ".next", "Skipped Forward")
        add("message." + SpotifyMod.ID + ".previous", "Skipped Backward")
        add("message." + SpotifyMod.ID + ".error", "You should have an active Spotify player first.")
    }
}