package qingzhixing.weird_items.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public final class ModItem {
    public static final Item CustomItem = ModItemRegister.register(
            new Item(new FabricItemSettings()),
            "custom_item"
    );

    public static void initialize() {
    }
}
