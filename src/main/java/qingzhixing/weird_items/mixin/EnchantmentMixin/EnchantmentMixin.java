package qingzhixing.weird_items.mixin.EnchantmentMixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
class EnchantmentMixin {
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    protected void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        //  Using Mixin inheritance so we can keep compatibility with mods that override this.
    }
}
