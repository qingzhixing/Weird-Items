package qingzhixing.weird_items.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.item.FluidModificationItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentBucketMixin extends EnchantmentMixin {
    @Override
    protected void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        var stackItem = stack.getItem();
        Arrays.stream(stackItem.getClass().getInterfaces()).forEach(interfaceClass -> {
                    if (interfaceClass == FluidModificationItem.class) {
                        cir.setReturnValue(true);
                    }
                }
        );
    }
}

@Mixin(Enchantment.class)
class EnchantmentMixin {
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    protected void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        //  Using Mixin inheritance so we can keep compatibility with mods that override this.
    }
}
