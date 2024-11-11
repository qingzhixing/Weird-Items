package qingzhixing.weird_items.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public final class WeirdItems {
    public static final Item SHAVED_ICE = ModItemRegister.register(
            new ShavedIce(new FabricItemSettings()),
            "shaved_ice"
    );

    public static void initialize() {
    }
}
