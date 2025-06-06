package net.pixi.vtmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pixi.vtmod.VtMod;
import net.pixi.vtmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,   VtMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VTMOD_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("vt_mod", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KEYDUNGEON.get()))
                .title(Component.translatable("creativetab.vtmod.vtmod"))
                .displayItems((itemDisplayParameters, output) -> {
                    
                    output.accept(ModItems.KEYDUNGEON.get());
                    output.accept(ModItems.KEYDUNGEON_LEVEL_TWO.get());
                    
                    output.accept(ModBlocks.DUNGEON_ONE_DOOR.get());
                    
                    output.accept(ModItems.PLASTIC.get());
                    output.accept(ModItems.PLASTIC_SWORD.get());   

                    output.accept(ModItems.ESSENCE_Of_LIFE.get());
                    output.accept(ModBlocks.ESSENCE_OF_LIFE_BLOCK.get());

                })
                .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
