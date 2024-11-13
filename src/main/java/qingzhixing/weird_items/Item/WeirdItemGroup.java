package qingzhixing.weird_items.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static qingzhixing.weird_items.ModInfo.MOD_ID;

public final class WeirdItemGroup {
    public static final ItemGroup
            WEIRD_ITEMS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(MOD_ID, "weird_item_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(WeirdItems.SHAVED_ICE))
                    .displayName(Text.translatable("itemGroup.weird_items.title"))
                    .entries(((displayContext, entries) -> {
                        entries.add(WeirdItems.SHAVED_ICE);
                        entries.add(WeirdItems.PRISMATIC_SHARD);
                        entries.add(WeirdItems.GALAXY_SWORD);
                    }))
                    .build()
    );

    public static void initialize() {
    }
}
