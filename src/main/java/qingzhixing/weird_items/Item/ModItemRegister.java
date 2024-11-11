package qingzhixing.weird_items.Item;

import net.fabricmc.loader.impl.util.log.Log;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static qingzhixing.weird_items.ModInfo.MOD_ID;
import static qingzhixing.weird_items.ModInfo.MOD_LOG_CATEGORY;

public final class ModItemRegister {
    public static Item register(Item item, String item_id) {
        // Create Identifier
        var itemID = new Identifier(MOD_ID, item_id);
        // Register Item
        var registry = Registry.register(Registries.ITEM, itemID, item);

        Log.info(MOD_LOG_CATEGORY, "Registered item: " + item_id);

        // Return registered item
        return registry;
    }

    public static void initialize() {
        ModItem.initialize();
    }
}
