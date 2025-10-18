package net.kuko.remod.item;

import net.kuko.remod.ReMod;
import net.kuko.remod.item.custom.LaserItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface ModItems {
    DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReMod.MOD_ID);

    DeferredItem<Item> LASER = ITEMS.register("laser",
            () -> new LaserItem(new Item.Properties()));

    static void registerItems(IEventBus bus) {
        ITEMS.register(bus);
    }
}
