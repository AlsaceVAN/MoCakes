package dev.alsaceVan.mocake.common.effect.init

import dev.alsaceVan.mocake.common.effect.impl.PoppingCandyEffect
import dev.alsaceVan.mocake.common.util.RegistryHandler
import net.minecraft.world.effect.MobEffect
import net.minecraftforge.registries.RegistryObject

object EffectInit {
  var poppingCandy:RegistryObject[MobEffect] = _
  def register():Unit = {
    poppingCandy = RegistryHandler.Effects.register("popping_candy", () => new PoppingCandyEffect)
  }
}
