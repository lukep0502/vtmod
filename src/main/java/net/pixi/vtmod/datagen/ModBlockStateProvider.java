package net.pixi.vtmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
// import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
// import net.minecraftforge.registries.ForgeRegistries;
// import net.minecraftforge.registries.RegistryObject;
import net.pixi.vtmod.VtMod;
import net.pixi.vtmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VtMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        
        blockWithItem(ModBlocks.ESSENCE_OF_LIFE_BLOCK);
        doorBlockWithRenderType(ModBlocks.DUNGEON_ONE_DOOR.get(), modLoc("block/dungeon_one_door_bottom"), modLoc("block/dungeon_one_door_top"), "cutout");


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
         simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    // private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
    //     simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("vtmod:block/" +
    //             ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    // }

    // private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
    //     simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("vtmod:block/" +
    //             ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    // }
}
