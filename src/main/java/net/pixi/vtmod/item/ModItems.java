package net.pixi.vtmod.item;

//import net.minecraft.world.item.Items; ver atributos vanilla EX: WOOD_SWORD
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixi.vtmod.VtMod;


public class ModItems {
        public static final DeferredRegister<Item> ITEMS = 
               DeferredRegister.create(ForgeRegistries.ITEMS, VtMod.MOD_ID);

        public static final RegistryObject<Item> KEYDUNGEON = ITEMS.register("keydungeon", 
               () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> KEYDUNGEON_LEVEL_TWO = ITEMS.register("keydungeon_level_two", 
               () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic", 
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ESSENCE_Of_LIFE = ITEMS.register("essence_of_life", 
                () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> PLASTIC_SWORD = ITEMS.register("plastic_sword", 
                () -> new SwordItem(ModToolTiers.PLASTIC, new Item.Properties()
                .attributes(SwordItem.createAttributes(ModToolTiers.PLASTIC, 1, -2.4f))));



        public static void register(IEventBus eventBus){
                ITEMS.register(eventBus);
        }

}
