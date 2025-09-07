package net.kuko.remod.item;

import net.kuko.remod.ReMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReMod.MOD_ID);

    public static void registerModItems(IEventBus bus) {
        ITEMS.register(bus);
    }
}
    