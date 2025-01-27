package qingzhixing.weird_items.mixin.EnchantmentMixin;

import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.item.BucketItem;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentBucketMixin extends EnchantmentMixin {
    @Override
    protected void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        var stackItem = stack.getItem();
        if (!(stackItem instanceof EntityBucketItem) && stackItem instanceof BucketItem) {
            cir.setReturnValue(true);
        }
    }
}

