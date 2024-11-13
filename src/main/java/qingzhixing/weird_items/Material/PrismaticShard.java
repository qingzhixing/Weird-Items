package qingzhixing.weird_items.Material;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class PrismaticShard extends Item {
    public PrismaticShard(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(
                Text.translatable("item.weird_items.prismatic_shard.tooltip")
                        .formatted(Formatting.BOLD, Formatting.LIGHT_PURPLE)
        );
    }
}
