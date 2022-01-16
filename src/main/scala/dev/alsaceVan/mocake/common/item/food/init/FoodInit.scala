package dev.alsaceVan.mocake.common.item.food.init

import dev.alsaceVan.mocake.client.creativeTab.Tabs
import dev.alsaceVan.mocake.common.block.init.BlockInit
import dev.alsaceVan.mocake.common.effect.init.EffectInit
import dev.alsaceVan.mocake.common.item.food.base.BaseCakeBlockItem
import dev.alsaceVan.mocake.common.item.food.properties.FoodsProperties
import dev.alsaceVan.mocake.common.tools.player.PlayerManagement
import dev.alsaceVan.mocake.common.util.RegistryHandler
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.{Item, ItemStack}
import net.minecraft.world.level.Level

object FoodInit {


  final def register(): Unit = {
    //Chocolate Cake
    RegistryHandler.Items.register("chocolate_cake",
      () => new BaseCakeBlockItem(BlockInit.chocolateCake.get(), 14, 1.4F))
    RegistryHandler.Items.register("rainbow_chocolate_cake",
      () => new BaseCakeBlockItem(BlockInit.rainbowChocolateCake.get(), 14, 2.1F))
    RegistryHandler.Items.register("popping_candy_raw",
      () => new Item(new Properties().tab(Tabs.FOOD)))
    RegistryHandler.Items.register("popping_candy",
      () => new BaseFoodItem(FoodsProperties.poppingCandy) {
        override def finishUsingItem(stack: ItemStack, level: Level, eater: LivingEntity):
        ItemStack = {
          val olderEffect = eater.getEffect(EffectInit.poppingCandy.get)
          val olderTime = if (olderEffect != null) olderEffect.getDuration else 0
          val olderAmp = if (olderEffect != null) olderEffect.getAmplifier else 0
          eater.addEffect(new MobEffectInstance(EffectInit.poppingCandy.get(), math.max((2400 + olderTime) * 2 / 3, 2400 + olderTime), olderAmp + 1))
          PlayerManagement.awardAdvancement(eater, "mocake:pop_rocks")
          super.finishUsingItem(stack, level, eater)
        }
      })

  }

  class BaseFoodItem(food: FoodProperties) extends Item(new Properties().food(food).tab(Tabs.FOOD))
}
