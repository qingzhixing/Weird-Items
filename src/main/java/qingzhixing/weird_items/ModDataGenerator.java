package qingzhixing.weird_items;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import qingzhixing.weird_items.Recipes.WeirdItemRecipeGenerator;

// REF: https://wiki.fabricmc.net/tutorial:datagen_setup
public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Adding a provider example:
        //
        // pack.addProvider(AdvancementsProvider::new);
        pack.addProvider(WeirdItemRecipeGenerator::new);
    }
}
