package net.kuko.remod;

import net.kuko.remod.block.entity.renderer.FiberGeneratorBlockEntityRenderer;
import net.kuko.remod.init.ModBlockEntities;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = ReModNeoForgified.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = ReModNeoForgified.MOD_ID, value = Dist.CLIENT)
public class ReModNeoForgifiedClient {
    public ReModNeoForgifiedClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        ReModNeoForgified.LOGGER.info("HELLO FROM CLIENT SETUP");
        ReModNeoForgified.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.FIBER_GENERATOR_BE.get(),
                FiberGeneratorBlockEntityRenderer::new);
    }
}
