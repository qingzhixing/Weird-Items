package qingzhixing.weird_items.Item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ShavedIce extends Item {

    /*
     * @usage: when player right-clicks on ice related block, replace it with upgraded ice
     * @return: ActionResult.PASS if the block is not ice, otherwise ActionResult.SUCCESS
     * @note: this method is called by the server when the player right-clicks on a block
     * @note:
     *  ice -> packed ice
     *  snow -> snow block
     *  packed ice -> blue ice
     * */
    static final Map<Block, Block> IceToUpgradeMap = new HashMap<>() {
        {
            put(Blocks.ICE, Blocks.PACKED_ICE);
            put(Blocks.SNOW, Blocks.SNOW_BLOCK);
            put(Blocks.PACKED_ICE, Blocks.BLUE_ICE);
        }
    };
    private static final int PARTICLE_COUNT = 10;

    public ShavedIce(Settings settings) {
        super(settings
                .food(new FoodComponent.Builder()
                        .hunger(3)
                        .saturationModifier(0.5f)
                        .snack()
                        .alwaysEdible()
                        .statusEffect(new StatusEffectInstance(
                                StatusEffects.GLOWING, 300
                        ), 1.0f)
                        .statusEffect(new StatusEffectInstance(
                                StatusEffects.ABSORPTION, 300, 0
                        ), 1.0f)
                        .statusEffect(new StatusEffectInstance(
                                StatusEffects.SPEED, 300, 0
                        ), 1.0f)
                        .build()
                )
        );
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer() == null) {
            return ActionResult.PASS;
        }

        var targetBlockPos = context.getBlockPos();
        var targetBlockState = context.getWorld().getBlockState(targetBlockPos);
        var player = context.getPlayer();
        var itemStack = context.getStack();

        if (IceToUpgradeMap.containsKey(targetBlockState.getBlock())) {
            // replace the block with the upgraded block
            var newBlock = IceToUpgradeMap.get(targetBlockState.getBlock());
            context.getWorld().setBlockState(targetBlockPos, newBlock.getDefaultState());

            // handle inventory
            if (!player.isCreative()) {
                // construct Predicate to filter out the item stack
                Predicate<ItemStack> filter = stack -> stack.getItem() == itemStack.getItem();
                player.getInventory().remove(filter, 1, player.getInventory());
            }

            // play sound
            BlockSoundGroup blockSoundGroup = targetBlockState.getSoundGroup();
            context.getWorld().playSound(player, targetBlockPos, blockSoundGroup.getBreakSound(), SoundCategory.BLOCKS);

            // spawn particles
            for (int i = 0; i < PARTICLE_COUNT; i++) {
                double x = targetBlockPos.getX() + 0.5 + (Math.random() - 0.5);
                double y = targetBlockPos.getY() + 1.2 + (Math.random() - 0.5) * 0.2;
                double z = targetBlockPos.getZ() + 0.5 + (Math.random() - 0.5);
                double vx = (Math.random() - 0.5);
                double vy = (Math.random() - 0.5);
                double vz = (Math.random() - 0.5);
                context.getWorld().addParticle(ParticleTypes.COMPOSTER, true, x, y, z, vx, vy, vz);
            }

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("tooltip.weird_items.shaved_ice").formatted(Formatting.GOLD, Formatting.BOLD));
    }
}
