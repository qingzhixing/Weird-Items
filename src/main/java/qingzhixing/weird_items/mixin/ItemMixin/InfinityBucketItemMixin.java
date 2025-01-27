package qingzhixing.weird_items.mixin.ItemMixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BucketItem.class)
public class InfinityBucketItemMixin {
    @Inject(method = "getEmptiedStack", at = @At("HEAD"), cancellable = true)
    private static void getEmptiedStack(ItemStack stack, PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        if (EnchantmentHelper.get(stack).containsKey(Enchantments.INFINITY)) {
            cir.setReturnValue(stack);
        }
    }
}
