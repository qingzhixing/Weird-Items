package qingzhixing.weird_items.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static qingzhixing.weird_items.ModInfo.MOD_ID;

public final class ModEnchantmentRegister {
    private final static Logger LOGGER = LogManager.getLogger(ModEnchantmentRegister.class);

    public static Enchantment register(Enchantment enchantment, String enchantment_id) {
        // Create Identifier
        var enchantmentID = new Identifier(MOD_ID, enchantment_id);
        // Register Enchantment
        var registry = Registry.register(Registries.ENCHANTMENT, enchantmentID, enchantment);

        LOGGER.log(Level.INFO, String.format("Registered Enchantment: %s", enchantment_id));

        return registry;
    }

    public static void initialize() {
        WeirdEnchantments.initialize();
    }
}
