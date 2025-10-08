package net.kuko.remod.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class MyScreen extends Screen {
    public MyScreen() {
        super(Component.literal("the screen"));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        // Draw plain dark background without blur
        // Draw your translucent panel
        guiGraphics.fill(
                10, 10,
                this.width - 10, this.height - 10,
                0xCC99F2E9 // semi-transparent ARGB
        );

        // Draw buttons/labels/etc.
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

}
