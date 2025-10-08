package net.kuko.remod.item.custom;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class WeakenedSword extends SwordItem {
    public WeakenedSword(Properties p_properties) {
        super(Tiers.DIAMOND, p_properties);
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.getMaxHealth() > 20) {
            stack.hurtAndBreak(20, target, Objects.requireNonNull(stack.getEquipmentSlot()));
            Level level = attacker.level();
            if (!level.isClientSide) {
                RandomSource random = level.getRandom();
                ((ServerLevel) level).addParticle(ParticleTypes.HEART,
                        target.position().x,
                        target.position().y,
                        target.position().z,
                        random.nextFloat(),
                        random.nextFloat(),
                        random.nextFloat());
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}
