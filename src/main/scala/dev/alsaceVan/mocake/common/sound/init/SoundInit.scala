package dev.alsaceVan.mocake.common.sound.init

import dev.alsaceVan.mocake.common.MoCakes
import dev.alsaceVan.mocake.common.util.RegistryHandler
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent

object SoundInit {
  val poppingCandy = "popping_candy"
  def register(): Unit = {
    initSound(poppingCandy)
  }

  private def initSound(soundId: String): Unit = {
    RegistryHandler.Sounds.register(soundId, () => new SoundEvent(new ResourceLocation(MoCakes.MOD_ID, soundId)))
  }
}
