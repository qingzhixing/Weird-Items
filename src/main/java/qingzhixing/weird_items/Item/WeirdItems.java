package qingzhixing.weird_items.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import qingzhixing.weird_items.Material.PrismaticShard;

public final class WeirdItems {
    public static final Item SHAVED_ICE = ModItemRegister.register(
            new ShavedIce(new FabricItemSettings()),
            "shaved_ice"
    );
    public static final Item PRISMATIC_SHARD = ModItemRegister.register(
            new PrismaticShard(new FabricItemSettings()),
            "prismatic_shard"
    );

    public static void initialize() {
    }
}
