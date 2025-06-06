package net.pixi.vtmod.datagen;

import net.pixi.vtmod.VtMod;
import net.pixi.vtmod.block.ModBlocks;
import net.pixi.vtmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VtMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.KEYDUNGEON.get());
        basicItem(ModItems.KEYDUNGEON_LEVEL_TWO.get());

        simpleBlockItem(ModBlocks.DUNGEON_ONE_DOOR);

        basicItem(ModItems.PLASTIC.get());
        handheldItem(ModItems.PLASTIC_SWORD);

        basicItem(ModItems.ESSENCE_Of_LIFE.get());
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VtMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VtMod.MOD_ID,"item/" + item.getId().getPath()));
    }

}
