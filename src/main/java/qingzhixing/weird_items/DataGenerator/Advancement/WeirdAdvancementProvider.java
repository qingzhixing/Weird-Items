package qingzhixing.weird_items.DataGenerator.Advancement;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;

import java.util.function.Consumer;

public class WeirdAdvancementProvider extends FabricAdvancementProvider {

    public WeirdAdvancementProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        new WeirdAdvancements().accept(consumer);
    }
}
