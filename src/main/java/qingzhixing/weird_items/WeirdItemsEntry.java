package qingzhixing.weird_items;

import net.fabricmc.api.ModInitializer;
import qingzhixing.weird_items.Enchantment.ModEnchantmentRegister;
import qingzhixing.weird_items.Item.ModItemRegister;
import qingzhixing.weird_items.Item.WeirdItemGroup;

public class WeirdItemsEntry implements ModInitializer {

    @Override
    public void onInitialize() {
        ModItemRegister.initialize();
        WeirdItemGroup.initialize();
        ModEnchantmentRegister.initialize();
    }
}
