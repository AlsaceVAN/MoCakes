package dev.intelligentcreations.mocake.common.item

import dev.intelligentcreations.mocake.client.creativeTab.Tabs
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.{BlockItem, Item, ItemStack}
import net.minecraft.world.level.block.Block

class BaseCakeBlockItem(cake:Block, nutrition:Int, saturation:Float) extends BlockItem(cake, new Item.Properties().stacksTo(1).tab(Tabs.FOOD).food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).alwaysEat().build())){
  override def getUseDuration(stack : ItemStack): Int = 80
}
