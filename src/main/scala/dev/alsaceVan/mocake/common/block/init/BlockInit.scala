package dev.alsaceVan.mocake.common.block.init

import dev.alsaceVan.mocake.common.block.base.BaseCakeBlock
import dev.alsaceVan.mocake.common.util.RegistryHandler
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.RegistryObject

object BlockInit {

  var chocolateCake: RegistryObject[Block] = _
  var rainbowChocolateCake: RegistryObject[Block] = _

  final def register(): Unit = {
    chocolateCake = RegistryHandler.Blocks.register("chocolate_cake",
      () => new BaseCakeBlock(2, 0.2F))
    rainbowChocolateCake = RegistryHandler.Blocks.register("rainbow_chocolate_cake",
      () => new BaseCakeBlock(2, 0.3F))
  }
}
