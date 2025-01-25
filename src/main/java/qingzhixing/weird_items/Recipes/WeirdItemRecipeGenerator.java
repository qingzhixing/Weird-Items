package qingzhixing.weird_items.Recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import qingzhixing.weird_items.Item.WeirdItems;

import java.util.function.Consumer;

public final class WeirdItemRecipeGenerator extends FabricRecipeProvider {

    public WeirdItemRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    private void CraftingRecipe(Consumer<RecipeJsonProvider> consumer) {
        // 银河之剑配方
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, WeirdItems.GALAXY_SWORD)
                .pattern("CAC")
                .pattern("CAC")
                .pattern(" B ")
                .input('A', WeirdItems.PRISMATIC_SHARD)
                .input('B', Items.STICK)

                .input('C', Ingredient.ofItems(Items.NETHERITE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(WeirdItems.PRISMATIC_SHARD),
                        FabricRecipeProvider.conditionsFromItem(WeirdItems.PRISMATIC_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(consumer);

        // 五彩石配方: 青金石、钻石、绿宝石、黄金、红石、紫水晶、铜
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, WeirdItems.PRISMATIC_SHARD)
                .input(Ingredient.ofItems(Items.LAPIS_LAZULI))
                .criterion(FabricRecipeProvider.hasItem(Items.LAPIS_LAZULI), FabricRecipeProvider.conditionsFromItem(Items.LAPIS_LAZULI))
                .input(Ingredient.ofItems(Items.GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .input(Ingredient.ofItems(Items.DIAMOND))
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND), FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .input(Ingredient.ofItems(Items.REDSTONE))
                .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE), FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
                .input(Ingredient.ofItems(Items.EMERALD))
                .criterion(FabricRecipeProvider.hasItem(Items.EMERALD), FabricRecipeProvider.conditionsFromItem(Items.EMERALD))
                .input(Ingredient.ofItems(Items.AMETHYST_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.AMETHYST_SHARD), FabricRecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .input(Ingredient.ofItems(Items.COPPER_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(consumer);
    }

    private void SmithingTransformRecipe(Consumer<RecipeJsonProvider> consumer) {
        // 无限水桶
        RecipeProvider.offerNetheriteUpgradeRecipe(
                consumer,
                Items.WATER_BUCKET,
                RecipeCategory.TOOLS,
                WeirdItems.INFINITE_WATER_BUCKET
        );
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        CraftingRecipe(consumer);
        SmithingTransformRecipe(consumer);
    }
}
