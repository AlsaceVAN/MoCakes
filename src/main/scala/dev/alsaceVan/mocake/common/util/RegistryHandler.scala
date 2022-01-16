package dev.alsaceVan.mocake.common.util

import dev.alsaceVan.mocake.common.MoCakes
import dev.alsaceVan.mocake.common.block.init.BlockInit
import dev.alsaceVan.mocake.common.effect.init.EffectInit
import dev.alsaceVan.mocake.common.item.food.init.FoodInit
import dev.alsaceVan.mocake.common.sound.init.SoundInit
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.{DeferredRegister, ForgeRegistries}

object RegistryHandler {
  val Sounds: DeferredRegister[SoundEvent] = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MoCakes.MOD_ID)
  val Effects: DeferredRegister[MobEffect] = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MoCakes.MOD_ID)
  val Blocks: DeferredRegister[Block] = DeferredRegister.create(ForgeRegistries.BLOCKS, MoCakes.MOD_ID)
  val Items: DeferredRegister[Item] = DeferredRegister.create(ForgeRegistries.ITEMS, MoCakes.MOD_ID)
  val eventBus: IEventBus = FMLJavaModLoadingContext.get().getModEventBus

  final def register(): Unit = {
    SoundInit.register()
    EffectInit.register()
    BlockInit.register()
    FoodInit.register()
    Sounds.register(eventBus)
    Effects.register(eventBus)
    Blocks.register(eventBus)
    Items.register(eventBus)
  }
}
