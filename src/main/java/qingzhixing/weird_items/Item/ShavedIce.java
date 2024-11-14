package qingzhixing.weird_items.Item;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import qingzhixing.weird_items.Particle.WeirdParticleHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ShavedIce extends Item {
    private static final int MAX_USE_TIME = 32;
    private static final int PARTICLE_COUNT = 8;
    private static final Map<Block, Block> ICE_TO_UPGRADE_MAP = new HashMap<>() {
        {
            put(Blocks.ICE, Blocks.PACKED_ICE);
            put(Blocks.SNOW, Blocks.SNOW_BLOCK);
            put(Blocks.PACKED_ICE, Blocks.BLUE_ICE);
        }
    };

    public ShavedIce(Settings settings) {
        super(settings
                .food(new FoodComponent.Builder()
                        .hunger(3)
                        .saturationModifier(0.5f)
                        .alwaysEdible()
                        .statusEffect(new StatusEffectInstance(
                                StatusEffects.GLOWING, 300
                        ), 1.0f)
                        .statusEffect(new StatusEffectInstance(
                                StatusEffects.SPEED, 300, 0
                        ), 1.0f)
                        .build()
                )
        );
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return MAX_USE_TIME;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!stack.isFood()) return stack;
        Item item = stack.getItem();

        // requireNonNull 可能会在这里产生报错
        // 将食物效果添加到玩家身上
        for (Pair<StatusEffectInstance, Float> pair : Objects.requireNonNull(item.getFoodComponent()).getStatusEffects()) {
            if (!world.isClient && pair.getFirst() != null && world.random.nextFloat() < pair.getSecond()) {
                user.addStatusEffect(new StatusEffectInstance(pair.getFirst()));
            }
        }

        // consume the item
        if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
            stack.decrement(1);
        }

        user.emitGameEvent(GameEvent.EAT);
        return stack;
    }

    /*
     * @usage: when player right-clicks on ice related block, replace it with upgraded ice
     * @return: ActionResult.PASS if the block is not ice, otherwise ActionResult.SUCCESS
     * @note: this method is called by the server when the player right-clicks on a block
     * @note:
     *  ice -> packed ice
     *  snow -> snow block
     *  packed ice -> blue ice
     * */
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var targetBlockPos = context.getBlockPos();
        var targetBlockState = context.getWorld().getBlockState(targetBlockPos);
        var player = context.getPlayer();

        if (player == null) {
            return ActionResult.FAIL;
        }

        if (ICE_TO_UPGRADE_MAP.containsKey(targetBlockState.getBlock())) {
            // replace the block with the upgraded block
            var newBlock = ICE_TO_UPGRADE_MAP.get(targetBlockState.getBlock());
            context.getWorld().setBlockState(targetBlockPos, newBlock.getDefaultState());

            // consume the item
            ItemUsage.consumeHeldItem(context.getWorld(), player, context.getHand());

            // play sound
            BlockSoundGroup blockSoundGroup = targetBlockState.getSoundGroup();
            context.getWorld().playSound(player, targetBlockPos, blockSoundGroup.getBreakSound(), SoundCategory.BLOCKS);

            Random random = context.getWorld().getRandom();

            // spawn particles
            WeirdParticleHelper.AddParticle(
                    random,
                    targetBlockPos,
                    ParticleTypes.COMPOSTER,
                    PARTICLE_COUNT,
                    context.getWorld()
            );

            player.emitGameEvent(GameEvent.BLOCK_CHANGE, player);

            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("tooltip.weird_items.shaved_ice.desc").formatted(Formatting.AQUA));
        tooltip.add(Text.translatable("tooltip.weird_items.shaved_ice").formatted(Formatting.GOLD, Formatting.BOLD));
    }
}
