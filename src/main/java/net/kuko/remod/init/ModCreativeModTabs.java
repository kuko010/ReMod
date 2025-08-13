package net.kuko.remod.init;

import net.kuko.remod.ReModNeoForgified;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReModNeoForgified.MOD_ID);

    //CREATIVE_MODE_TABS is a DeferredRegister<CreativeModeTab>
    public static final Supplier<CreativeModeTab> REMOD_TAB = CREATIVE_MODE_TABS.register("remod_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creative_tab." + ReModNeoForgified.MOD_ID + ".remod_tab"))
            .icon(() -> new ItemStack(Items.NETHERITE_INGOT))
            .displayItems((params, output) -> {

            })
            .build()
    );

    public static void modCreativeTabsInit(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
