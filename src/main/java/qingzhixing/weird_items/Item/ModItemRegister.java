package qingzhixing.weird_items.Item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static qingzhixing.weird_items.ModInfo.MOD_ID;

public final class ModItemRegister {
    private final static Logger LOGGER = LogManager.getLogger(ModItemRegister.class);

    public static Item register(Item item, String item_id) {
        // Create Identifier
        var itemID = new Identifier(MOD_ID, item_id);
        // Register Item
        var registry = Registry.register(Registries.ITEM, itemID, item);

        LOGGER.log(Level.INFO, String.format("Registered item: %s", item_id));

        // Return registered item
        return registry;
    }

    public static void initialize() {
        WeirdItems.initialize();
    }
}
