package net.kuko.remod.item.custom;

import net.kuko.remod.ReMod;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;


//TODO: I wanna make tool with that i can grab blocks,
//  it will turn them into sand falling entities, and then i can place them. Meow
public class GravityItem extends Item {
    public GravityItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide()) {
            EntityHitResult entity = ProjectileUtil.getEntityHitResult(
                    player,
                    player.getEyePosition(),
                    player.getEyePosition().add(player.getViewVector(1.0f).scale(5.0)),
                    player.getBoundingBox().expandTowards(player.getViewVector(1.0f).scale(5)).inflate(1.0),
                    e -> !e.isSpectator() && e.isAlive(),
                    5
            );
            ReMod.LOGGER.info("Player? {}", player);
            entity.getEntity().setCustomName(Component.literal("Right Clicked"));
            ReMod.LOGGER.info("Entity : {}; Has been renamed",entity.getEntity().getName().toString());
            entity.getEntity().move(MoverType.SELF, new Vec3(0,5,0));

            return super.use(level, player, usedHand);
        }
        return super.use(level, player, usedHand);
    }

//    @Override
//    public InteractionResult useOn(UseOnContext context) {
//        return super.useOn(context);
//    }

    public void Η() {

    }


//    @Override
//    public Component getName(ItemStack stack) {
//        return Component.empty()
//                .append(Component.literal("Potato's Tool").withStyle(ChatFormatting.AQUA));
//    }

    public static final int level = 100;
//    @Override
//    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
//                                TooltipFlag tooltipFlag) {
//        tooltipComponents.add(Component.literal(String.format("Level: %d | 1000", level)).withStyle(ChatFormatting.GOLD));
//        tooltipComponents.add(Component.literal(String.format("XP: %d | 1100", level)).withStyle(ChatFormatting.AQUA));
//        tooltipComponents.add(Component.literal(" "));
//        tooltipComponents.add(Component.literal("Bonuses:").withStyle(ChatFormatting.YELLOW));
//        tooltipComponents.add(Component.literal(" +Attack Damage: 20.0").withStyle(ChatFormatting.GRAY));
//        tooltipComponents.add(Component.literal(" +Mining Speed: 50.0").withStyle(ChatFormatting.GRAY));
//        tooltipComponents.add(Component.literal(" Crit Chance: 6% x1.6").withStyle(ChatFormatting.DARK_AQUA));
//        tooltipComponents.add(Component.literal(" Poison on hit 4s").withStyle(ChatFormatting.GREEN));
//        tooltipComponents.add(Component.literal(" +Reach: +0.7").withStyle(ChatFormatting.DARK_PURPLE));
//
//        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//    }


}
