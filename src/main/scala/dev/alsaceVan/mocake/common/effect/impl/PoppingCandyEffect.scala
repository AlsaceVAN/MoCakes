package dev.alsaceVan.mocake.common.effect.impl

import com.mojang.blaze3d.vertex.PoseStack
import dev.alsaceVan.mocake.common.MoCakes
import net.minecraft.client.gui.GuiComponent
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.effect.{MobEffect, MobEffectCategory, MobEffectInstance}
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.level.Level
import net.minecraftforge.client.EffectRenderer

import java.util.function.Consumer

class PoppingCandyEffect extends MobEffect(MobEffectCategory.NEUTRAL, 0){
  override def applyEffectTick(entity : LivingEntity, amplifier : Int): Unit = {
    val level:Level = entity.level
    if(level.getDayTime % 100 == 0){
      entity.playSound(new SoundEvent(new ResourceLocation(MoCakes.MOD_ID, "popping_candy")), math.max(1F, 0.4F + 0.1F * amplifier), 1F)
    }
  }

  override def isDurationEffectTick(duration : Int, amplifier : Int): Boolean = true

  override def initializeClient(consumer: Consumer[EffectRenderer]): Unit = {
    consumer.accept(new EffectRenderer {
      override def shouldRender(effect: MobEffectInstance): Boolean = false

      override def shouldRenderHUD(effect: MobEffectInstance): Boolean = false

      override def shouldRenderInvText(effect: MobEffectInstance): Boolean = false

      override def renderInventoryEffect(effect: MobEffectInstance, gui: EffectRenderingInventoryScreen[_], mStack: PoseStack, x: Int, y: Int, z: Float): Unit = {}

      override def renderHUDEffect(effect: MobEffectInstance, gui: GuiComponent, mStack: PoseStack, x: Int, y: Int, z: Float, alpha: Float): Unit = {}
    })
  }
}
