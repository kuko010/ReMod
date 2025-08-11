package net.kuko.remod.init;

import net.kuko.remod.ReModNeoForgified;
import net.kuko.remod.block.entity.FiberGeneratorBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.kuko.remod.ReModNeoForgified.MOD_ID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MOD_ID);

    public static final Supplier<BlockEntityType<FiberGeneratorBlockEntity>> FIBER_GENERATOR_BE =
            BLOCK_ENTITES.register("energizer_be", () -> BlockEntityType.Builder.of(
                     FiberGeneratorBlockEntity::new,
                    ModBlocks.FIBER_GENERATOR.get()
            ).build(null));


    public static void modBlockEntitiesInit(IEventBus bus) {
        BLOCK_ENTITES.register(bus);
    }

}
