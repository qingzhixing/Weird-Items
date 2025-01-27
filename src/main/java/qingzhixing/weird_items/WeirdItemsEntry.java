package qingzhixing.weird_items;

import net.fabricmc.api.ModInitializer;
import qingzhixing.weird_items.Enchantment.WeirdEnchantmentRegister;
import qingzhixing.weird_items.Item.WeirdItemGroup;
import qingzhixing.weird_items.Item.WeirdItemRegister;

public class WeirdItemsEntry implements ModInitializer {

    @Override
    public void onInitialize() {
        WeirdItemRegister.initialize();
        WeirdItemGroup.initialize();
        WeirdEnchantmentRegister.initialize();
    }
}
