package dev.intelligentcreations.mocake.common.item

import dev.intelligentcreations.mocake.common.block.init.BlockInit
import dev.intelligentcreations.mocake.common.util.RegistryHandler

object FoodInit {


  final def register():Unit = {
    //Chocolate Cake
    RegistryHandler.Items.register("chocolate_cake",
      () => new BaseCakeBlockItem(BlockInit.chocolateCake.get(), 14, 1.4F))
    RegistryHandler.Items.register("rainbow_chocolate_cake",
      () => new BaseCakeBlockItem(BlockInit.rainbowChocolateCake.get(), 14, 2.1F))
  }
}
