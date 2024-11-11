package qingzhixing.weird_items;

import net.fabricmc.api.ModInitializer;
import qingzhixing.weird_items.Item.ModItemRegister;

public class Weird_items implements ModInitializer {

    @Override
    public void onInitialize() {
        ModItemRegister.initialize();
    }
}
