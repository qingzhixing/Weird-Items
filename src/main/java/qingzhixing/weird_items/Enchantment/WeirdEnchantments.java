package qingzhixing.weird_items.Enchantment;

import net.minecraft.enchantment.Enchantment;

public final class WeirdEnchantments {
    public static final Enchantment FROST = ModEnchantmentRegister.register(new FrostEnchantment(), "frost");

    public static void initialize() {
    }
}
