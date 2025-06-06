package net.pixi.vtmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
//import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pixi.vtmod.VtMod;
import net.pixi.vtmod.block.ModBlocks;
//import net.pixi.vtmod.block.ModBlocks;
import net.pixi.vtmod.util.ModTags;

import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VtMod.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("null")
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ESSENCE_OF_LIFE_BLOCK.get());
                

        // tag(BlockTags.NEEDS_IRON_TOOL)
        //         .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

        // tag(BlockTags.NEEDS_DIAMOND_TOOL)
        //         .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

        

        tag(ModTags.Blocks.NEEDS_PLASTIC_TOOL)
                //.add(ModBlocks.DUNGEON_ONE_DOOR.get())
                //.add(Blocks.OBSIDIAN)
                .addTag(BlockTags.NEEDS_STONE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_PLASTIC_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_PLASTIC_TOOL);
    }
}
