package dev.alsaceVan.mocake.common.item.food.properties

import net.minecraft.world.food.FoodProperties
import net.minecraft.world.food.FoodProperties.Builder

object FoodsProperties {
  val poppingCandy: FoodProperties = new Builder().nutrition(1).saturationMod(0).alwaysEat().fast().build()
}
