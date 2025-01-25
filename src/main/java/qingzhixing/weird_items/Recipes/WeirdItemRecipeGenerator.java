package qingzhixing.weird_items.Recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import qingzhixing.weird_items.Item.WeirdItems;

import java.util.function.Consumer;

public final class WeirdItemRecipeGenerator extends FabricRecipeProvider {

    public WeirdItemRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        // 银河之剑配方
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, WeirdItems.GALAXY_SWORD)
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .input('A', WeirdItems.PRISMATIC_SHARD)
                .input('B', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(WeirdItems.PRISMATIC_SHARD),
                        FabricRecipeProvider.conditionsFromItem(WeirdItems.PRISMATIC_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(consumer);
    }
}
