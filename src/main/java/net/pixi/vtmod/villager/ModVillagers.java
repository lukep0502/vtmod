package net.pixi.vtmod.villager;

import com.google.common.collect.ImmutableSet;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixi.vtmod.VtMod;
import net.pixi.vtmod.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, VtMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, VtMod.MOD_ID);

    public static final RegistryObject<PoiType> TRADER_LIFE_POI = POI_TYPES.register("trader_life_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ESSENCE_OF_LIFE_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> TRADER_LIFE = VILLAGER_PROFESSIONS.register("trader_life",
            () -> new VillagerProfession("trader_life", holder -> holder.value() == TRADER_LIFE_POI.get(),
                    holder -> holder.value() == TRADER_LIFE_POI.get(), ImmutableSet.of(), ImmutableSet.of(), 
                    SoundEvents.VILLAGER_WORK_ARMORER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}