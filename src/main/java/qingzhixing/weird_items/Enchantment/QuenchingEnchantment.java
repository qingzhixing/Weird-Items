package qingzhixing.weird_items.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class QuenchingEnchantment extends Enchantment {
    protected QuenchingEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return super.getMinPower(level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!(target instanceof LivingEntity livingEntity)) {
            return;
        }
        // 30% chance to poison the target
        if (user.getRandom().nextDouble() < (0.2 + level * 0.1)) {
            livingEntity.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.POISON, 10 * level, level / 2
            ), user);
            // play sound effect
            target.getWorld().playSound(
                    target,
                    BlockPos.ofFloored(target.getPos()),
                    SoundEvents.ENTITY_PUFFER_FISH_STING,
                    SoundCategory.NEUTRAL,
                    0.5f,
                    1.0f
            );
        }
    }
}
