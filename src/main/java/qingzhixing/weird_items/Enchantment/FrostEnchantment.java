package qingzhixing.weird_items.Enchantment;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import qingzhixing.weird_items.Particle.WeirdParticleHelper;

public class FrostEnchantment extends Enchantment {
    // 达到140冰冻值之后会产生冰冻伤害
    private static final int BASE_FROZEN_TICKS = 140;
    private static final int FROZEN_TICK_PER_SECOND = 20 * 2;       // 每个游戏刻减少2霜冻值
    private static final int FROZEN_TIME_MAX_SECONDS = 10;          // 最多霜冻10秒
    private static final int MAX_FROZEN_TICKS = BASE_FROZEN_TICKS + FROZEN_TICK_PER_SECOND * FROZEN_TIME_MAX_SECONDS;
    private static final int FROZEN_PARTICLE_COUNT = 16;

    private static final BlockStateParticleEffect FROZEN_PARTICLE_EFFECT = new BlockStateParticleEffect(
            ParticleTypes.BLOCK,
            Blocks.ICE.getDefaultState()
    );

    protected FrostEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return super.getMinPower(level);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target.isOnFire()) {
            target.setFireTicks(0);
            target.setOnFire(false);
        }

        if (target instanceof LivingEntity livingTarget) {
            var frozenTicks = livingTarget.getFrozenTicks();
            var nextFrozenTicks = frozenTicks + (level + 1) * FROZEN_TICK_PER_SECOND;
            livingTarget.setFrozenTicks(Math.min(nextFrozenTicks, MAX_FROZEN_TICKS));
            livingTarget.addStatusEffect(
                    new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * (2 + level), (level / 3)),
                    user
            );
        }

        Random random = user.getRandom();

        // 产生冰冻粒子
        // TODO:为何没有效果?
        WeirdParticleHelper.AddParticle(
                random,
                target.getBlockPos(),
                FROZEN_PARTICLE_EFFECT,
                FROZEN_PARTICLE_COUNT,
                target.getWorld()
        );

        target.getWorld().playSound(
                target,
                BlockPos.ofFloored(target.getPos()),
                BlockSoundGroup.GLASS.getBreakSound(),
                SoundCategory.NEUTRAL,
                0.5f,
                1.0f
        );

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        // 弓箭和武器都可以
        return EnchantmentTarget.WEAPON.isAcceptableItem(stack.getItem())
                || EnchantmentTarget.BOW.isAcceptableItem(stack.getItem());
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return other != Enchantments.FIRE_ASPECT;
    }
}
