package qingzhixing.weird_items.DataGenerator.Tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class WeirdItemTagProvider extends FabricTagProvider<Item> {
    public WeirdItemTagProvider(FabricDataOutput output, RegistryKey<? extends Registry<Item>> registryKey, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registryKey, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

    }
}
