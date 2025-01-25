package qingzhixing.weird_items.Material;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import qingzhixing.weird_items.Item.WeirdItems;

public class PrismaticMaterial implements ToolMaterial {

    public static final PrismaticMaterial INSTANCE = new PrismaticMaterial();

    // 耐久
    @Override
    public int getDurability() {
        return 4514;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.NETHERITE;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(WeirdItems.PRISMATIC_SHARD);
    }
}
