package qingzhixing.weird_items.DataGenerator;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import qingzhixing.weird_items.DataGenerator.Advancement.WeirdAdvancementProvider;
import qingzhixing.weird_items.DataGenerator.LootTable.WeirdBlockLootTableProvider;
import qingzhixing.weird_items.DataGenerator.LootTable.WeirdChestLootTableProvider;
import qingzhixing.weird_items.DataGenerator.LootTable.WeirdEntityLootTableProvider;
import qingzhixing.weird_items.DataGenerator.Model.WeirdModelProvider;
import qingzhixing.weird_items.DataGenerator.Recipe.WeirdItemRecipeProvider;

// REF: https://wiki.fabricmc.net/tutorial:datagen_setup
public class WeirdDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Adding a provider example:
        //
        // pack.addProvider(AdvancementsProvider::new);
        pack.addProvider(WeirdItemRecipeProvider::new);

        pack.addProvider(WeirdAdvancementProvider::new);

        pack.addProvider(WeirdBlockLootTableProvider::new);
        pack.addProvider(WeirdChestLootTableProvider::new);
        pack.addProvider(WeirdEntityLootTableProvider::new);

        pack.addProvider(WeirdModelProvider::new);

        pack.addProvider(WeirdItemRecipeProvider::new);
    }
}
