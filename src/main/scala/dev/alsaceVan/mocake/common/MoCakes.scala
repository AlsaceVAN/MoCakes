package dev.alsaceVan.mocake.common

import dev.alsaceVan.mocake.common.util.RegistryHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod

@Mod(MoCakes.MOD_ID)
object MoCakes {
  final val MOD_ID = "mocake"
  RegistryHandler.register()
  MinecraftForge.EVENT_BUS.register(this)
}



