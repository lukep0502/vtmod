package net.pixi.vtmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.pixi.vtmod.VtMod;
import net.pixi.vtmod.item.ModItems;
import net.pixi.vtmod.loot.AddItemModifier;

import java.util.concurrent.CompletableFuture;
//Gradle net.minecraft:client extra -> data -> loot_table

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, VtMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {

        this.add("essence_of_life_from_zoombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie"))
                        .and(LootItemRandomChanceCondition.randomChance(0.5f)).build() }, // modified by the zopombies's own loot table
                ModItems.ESSENCE_Of_LIFE.get()));

    }
}