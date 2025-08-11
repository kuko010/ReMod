package net.kuko.remod.init;

import net.kuko.remod.ReModNeoForgified;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReModNeoForgified.MOD_ID);






    public static void modItemsInit(IEventBus bus) {
        ITEMS.register(bus);
    }
}
