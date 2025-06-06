package net.pixi.vtmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pixi.vtmod.VtMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PLASTIC_TOOL = createTag("needs_plastic_tool");
        public static final TagKey<Block> INCORRECT_FOR_PLASTIC_TOOL = createTag("incorrect_for_plastic_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(VtMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(VtMod.MOD_ID, name));
        }
    }
}
