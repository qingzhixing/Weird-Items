package qingzhixing.weird_items.DataGenerator.LootTable;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

// 方块战利品
public class WeirdBlockLootTableProvider extends SimpleFabricLootTableProvider {
    public WeirdBlockLootTableProvider(FabricDataOutput output) {
        super(output, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {

    }
}
