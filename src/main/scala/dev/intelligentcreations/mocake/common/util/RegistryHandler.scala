package dev.intelligentcreations.mocake.common.util

import dev.intelligentcreations.mocake.common.MoCakes
import dev.intelligentcreations.mocake.common.block.init.BlockInit
import dev.intelligentcreations.mocake.common.item.FoodInit
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.{DeferredRegister, ForgeRegistries}

object RegistryHandler {
  val Blocks:DeferredRegister[Block] = DeferredRegister.create(ForgeRegistries.BLOCKS, MoCakes.MOD_ID)
  val Items:DeferredRegister[Item] = DeferredRegister.create(ForgeRegistries.ITEMS, MoCakes.MOD_ID)
  val eventBus:IEventBus = FMLJavaModLoadingContext.get().getModEventBus

  final def register():Unit = {
    BlockInit.register()
    FoodInit.register()
    Blocks.register(eventBus)
    Items.register(eventBus)
  }
}
