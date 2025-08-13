package net.kuko.remod.datagen;


import net.kuko.remod.ReModNeoForgified;
import net.kuko.remod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ReModNeoForgified.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        tag(ModTags.Items.TRANSFORMABLE_ITEMS) // Create TODO: Create src/utils/ModTags.java
//                .add(ModItems.BISMUTH.get())
//                .add(ModItems.RAW_BISMUTH.get())
//                .add(Items.COAL)
//                .add(Items.STICK)
//                .add(Items.COMPASS);

//        tag(ModTags.Items.FIBERS)
//                .addTag(ItemTags.LOGS)            // All logs and stems
//                .addTag(ItemTags.PLANKS)          // All planks
//                .addTag(ItemTags.WOODEN_SLABS)    // Optional: slabs
//                .addTag(ItemTags.WOODEN_STAIRS)   // Optional: stairs
//                .addTag(ItemTags.WOODEN_FENCES)   // Optional: fences
//                .addTag(ItemTags.COALS)
//                .add(Items.LAVA_BUCKET)
//                .add(Items.COAL_BLOCK);

    }
}
