package net.kuko.remod.util;


import net.kuko.remod.ReModNeoForgified;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> FIBERS = createTag("fibers_blocks");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ReModNeoForgified.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FIBERS = createTag("fibers_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ReModNeoForgified.MOD_ID, name));
        }
    }
}
