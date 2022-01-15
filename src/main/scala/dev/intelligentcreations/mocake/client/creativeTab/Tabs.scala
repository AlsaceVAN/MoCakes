package dev.intelligentcreations.mocake.client.creativeTab

import dev.intelligentcreations.mocake.common.block.init.BlockInit
import net.minecraft.world.item.{CreativeModeTab, ItemStack}

object Tabs {
  val FOOD:CreativeModeTab = new CreativeModeTab("mocake.food") {
    override def makeIcon(): ItemStack = new ItemStack(BlockInit.chocolateCake.get())
  }
}
