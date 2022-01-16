package dev.alsaceVan.mocake.common.block.base

import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvents
import net.minecraft.stats.Stats
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.block.state.properties.{BlockStateProperties, IntegerProperty}
import net.minecraft.world.level.block.state.{BlockBehaviour, BlockState}
import net.minecraft.world.level.block.{CakeBlock, SoundType}
import net.minecraft.world.level.gameevent.GameEvent
import net.minecraft.world.level.material.Material
import net.minecraft.world.level.{Level, LevelAccessor}
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.{InteractionHand, InteractionResult}

class BaseCakeBlock(nutrition: Int, saturation: Float) extends CakeBlock(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)) {
  val BITES: IntegerProperty = BlockStateProperties.BITES

  override def use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult)
  : InteractionResult = {
    val stack = player.getItemInHand(hand)

    if (world.isClientSide) {
      if (eat(world, pos, state, player).consumesAction) return InteractionResult.SUCCESS
      if (stack.isEmpty) return InteractionResult.CONSUME
    }

    eat(world, pos, state, player)
  }

  protected def eat(world: LevelAccessor, pos: BlockPos, state: BlockState, player: Player):
  InteractionResult = {
    if (!player.canEat(false)) InteractionResult.PASS
    else {
      player.awardStat(Stats.EAT_CAKE_SLICE)
      player.getFoodData.eat(nutrition, saturation)
      player.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F)
      val i = state.getValue(BITES)
      world.gameEvent(player, GameEvent.EAT, pos)
      if (i < 6) world.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3)
      else {
        world.removeBlock(pos, false)
        world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos)
      }
      InteractionResult.SUCCESS
    }
  }
}
