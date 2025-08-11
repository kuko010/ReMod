package net.kuko.remod.init;

import net.kuko.remod.ReModNeoForgified;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReModNeoForgified.MOD_ID);

    //CREATIVE_MODE_TABS is a DeferredRegister<CreativeModeTab>
    public static final Supplier<CreativeModeTab> REMOD_TAB = CREATIVE_MODE_TABS.register("remod_tab", () -> CreativeModeTab.builder()
            //Set the title of the tab. Don't forget to add a translation!
            .title(Component.translatable("creative_tab." + ReModNeoForgified.MOD_ID + ".remod_tab"))
            //Set the icon of the tab.
            // TODO: when we will have our ingot, change the icon to it
            .icon(() -> new ItemStack(ModBlocks.FIBER_GENERATOR.get()))
            //Add your items to the tab.
            .displayItems((params, output) -> {
                output.accept(ModBlocks.FIBER_GENERATOR);
            })
            .build()
    );

    public static void modCreativeTabsInit(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
