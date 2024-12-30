package qingzhixing.weird_items.Enchantment;

import net.minecraft.enchantment.Enchantment;

public final class WeirdEnchantments {
    public static final Enchantment FROST = ModEnchantmentRegister.register(new FrostEnchantment(), "frost");

    public static final Enchantment QUENCHING = ModEnchantmentRegister.register(new QuenchingEnchantment(), "quenching");

    public static void initialize() {
    }
}
