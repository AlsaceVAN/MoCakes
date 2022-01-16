package dev.alsaceVan.mocake.common.tools.player

import net.minecraft.advancements.{Advancement, AdvancementProgress}
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.Entity

import scala.annotation.tailrec

object PlayerManagement {
  def awardAdvancement(entity:Entity, advId:String):Unit = {
    if (entity == null){
      return
    }
    entity match {
      case player:ServerPlayer =>{
        val advancement: Advancement = player.server.getAdvancements.getAdvancement(new ResourceLocation(advId))
        val advancementProgress: AdvancementProgress = player.getAdvancements.getOrStartProgress(advancement)
        if(!advancementProgress.isDone) completeTheAdvancement(player, advancement, advancementProgress)
      }
    }
  }

  @tailrec
  private def completeTheAdvancement(player: ServerPlayer, advancement: Advancement, advancementProgress: AdvancementProgress)
  :Unit = {
    val iterator = advancementProgress.getRemainingCriteria.iterator()
    if(iterator.hasNext){
      player.getAdvancements.award(advancement, iterator.next())
      completeTheAdvancement(player, advancement, advancementProgress)
    }
  }
}
