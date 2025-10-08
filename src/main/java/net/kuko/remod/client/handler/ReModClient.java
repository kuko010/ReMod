package net.kuko.remod.client.handler;


import net.kuko.remod.ReMod;
import net.kuko.remod.client.Keybindings;
import net.kuko.remod.client.screen.MyScreen;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.util.Lazy;

@Mod(value = ReMod.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = ReMod.MOD_ID, value = Dist.CLIENT)
public class ReModClient {
    public ReModClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        ReMod.LOGGER.info("HELLO FROM CLIENT SETUP");
        ReMod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
    @SubscribeEvent
    public static void registerBeR(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerBlockEntityRenderer(ModBlockEntities.FIBER_GENERATOR_BE.get(),
//                FiberGeneratorBlockEntityRenderer::new);
    }

    public static final Lazy<KeyMapping> REMOD_MAPPINGS = Lazy.of(
            () -> Keybindings.INSTANCE.MenuOpenKey

            /*...*/);

    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(REMOD_MAPPINGS.get());
    }



    @SubscribeEvent // on the game event bus only on the physical client
    public static void onClientTick(ClientTickEvent.Post event) {
        while (REMOD_MAPPINGS.get().consumeClick()) {
            // Execute logic to perform on click here
            Minecraft mc = Minecraft.getInstance();
            mc.player.displayClientMessage(Component.literal("Player has opened GUI."), false);
            Minecraft.getInstance().setScreen(new MyScreen());
        }
    }
}
