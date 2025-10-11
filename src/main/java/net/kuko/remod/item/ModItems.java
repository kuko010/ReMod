package net.kuko.remod.item;

import net.kuko.remod.ReMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReMod.MOD_ID);



    public static final DeferredItem<Item> GRAVITY = ITEMS.register("gravity",
            () -> new GravityItem(new Item.Properties()));

    public static final DeferredItem<Item> WEAKENED_SWORD = ITEMS.register("weakened_sword",
            () -> new WeakenedSword(new Item.Properties()));

    public static void registerItems(IEventBus bus) {
        ITEMS.register(bus);
    }
}
