package net.kuko.remod.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.kuko.remod.block.entity.FiberGeneratorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class FiberGeneratorBlockEntityRenderer implements BlockEntityRenderer<FiberGeneratorBlockEntity> {
    public FiberGeneratorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(FiberGeneratorBlockEntity blockEntity, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {


        // This is AI generated
        // Add null checks
        if (blockEntity == null || blockEntity.getLevel() == null) {
            return;
        }

        ItemStack stack = blockEntity.inventory.getStackInSlot(0);
        if (stack.isEmpty()) {
            return; // Don't render if no item
        }

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        if (itemRenderer == null) {
            return;
        }
        // This is not**** AI generated

        // Render the item
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.scale(0.6f, 0.6f, 0.6f);
        poseStack.mulPose(Axis.YP.rotationDegrees(blockEntity.getRenderingRotation()));

        itemRenderer.renderStatic(stack,
                ItemDisplayContext.FIXED,
                getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY,
                poseStack,
                bufferSource, blockEntity.getLevel(), 1);
        poseStack.popPose();


        Component itemName = Component.empty()
                .append(Component.literal("Item: "))
                .append(stack.getDisplayName());
        Component itemCount = Component.empty()
                .append(Component.literal(String.valueOf(stack.getCount())));

        float yName = 0.12f;
        float zName = -0.105f;
        float sScale = -0.0085f;
        float finalXs = 0.5f; // Centers on the block's X-axis

        Font fontRenderer = Minecraft.getInstance().font; // Move this up
        float textWidths = fontRenderer.width(itemName); // Get the text width
        float centeredTextXs = finalXs - (textWidths * (sScale)) / 2f; // Center the text

// Render the text NAME
        renderText(fontRenderer,
                poseStack,
                centeredTextXs, yName, zName, // Use centeredTextXs instead of textWidths
                sScale, sScale, sScale,
                itemName, bufferSource, packedLight, 0f, 0f); // Use 0,0 since we pre-calculated center

        float offSetY = 0.15f;
        float finalY = yName + offSetY;
        float finalX = 0.5f; // Centers on the block's X-axis
        float scaled = -0.005f;
        float actualScale = sScale + scaled; // Calculate the actual scale being used

        float textWidth = fontRenderer.width(itemCount); // Get the text width
        float centeredTextX = finalX - (textWidth * (actualScale)) / 2f; // Use actualScale for centering

        renderText(fontRenderer,
                poseStack,
                centeredTextX, finalY, zName,
                actualScale, actualScale, actualScale, // Use the same actualScale
                itemCount, bufferSource, packedLight, 0f, 0f); // Change to 0f, 0f since we pre-calculated center
    }


    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight,sLight);
    }

    private void renderText(Font fontRenderer, PoseStack poseStack, float translateX, float translateY, float translateZ,
                            float scaleX, float scaleY, float scaleZ, Component text,
                            MultiBufferSource bufferSource, int packedLight, float textX, float textY) {
        poseStack.pushPose();
        poseStack.translate(translateX, translateY, translateZ);
        poseStack.scale(scaleX, scaleY, scaleZ);


        fontRenderer.drawInBatch(
                text,
                textX, textY,
                0xFFFFFFFF,
                false,
                poseStack.last().pose(),
                bufferSource,
                Font.DisplayMode.NORMAL,
                0,
                packedLight
        );
        poseStack.popPose();
    }
}
