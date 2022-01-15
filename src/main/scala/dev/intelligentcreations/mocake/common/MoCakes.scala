package dev.intelligentcreations.mocake.common

import dev.intelligentcreations.mocake.common.util.RegistryHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod

@Mod(MoCakes.MOD_ID)
object MoCakes {
  final val MOD_ID = "mocake"
  RegistryHandler.register()
  MinecraftForge.EVENT_BUS.register(this)
}



