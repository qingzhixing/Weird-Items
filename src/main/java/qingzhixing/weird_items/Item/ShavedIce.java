package qingzhixing.weird_items.Item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ShavedIce extends Item {

    public ShavedIce(Settings settings) {
        super(settings.maxCount(37));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0f, 1.0f);
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("tooltip.weird_items.shaved_ice").formatted(Formatting.GOLD, Formatting.BOLD));
    }
}
