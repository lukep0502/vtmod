package net.pixi.vtmod.event;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pixi.vtmod.VtMod;
import net.pixi.vtmod.block.ModBlocks;
import net.pixi.vtmod.item.ModItems;
import net.pixi.vtmod.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.Event;



@Mod.EventBusSubscriber(modid = VtMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        // Processar só no servidor
        if (world.isClientSide) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Verifica se é nossa porta registrada (DUNGEON_ONE_DOOR)
        if (!(state.getBlock() instanceof DoorBlock) ||
            state.getBlock() != ModBlocks.DUNGEON_ONE_DOOR.get()) {
            return;
        }

        Player player = event.getEntity();
        
        ItemStack mainHand = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack offHand  = player.getItemInHand(InteractionHand.OFF_HAND);

        boolean hasKeyInMain = mainHand.getItem() == ModItems.KEYDUNGEON.get();
        boolean hasKeyInOff  = offHand.getItem()  == ModItems.KEYDUNGEON.get();
        boolean hasKey       = hasKeyInMain || hasKeyInOff;

        if (hasKey) {
            // Alterna o estado OPEN da porta
            boolean isOpen = state.getValue(BlockStateProperties.OPEN);
            world.setBlock(pos, state.setValue(BlockStateProperties.OPEN, !isOpen), 10);

            // (Opcional) Consumir a chave
            // if (hasKeyInMain) mainHand.shrink(1);
            // else offHand.shrink(1);

            // Cancela o clique padrão para não deixar a porta abrir/fechar duplamente
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.SUCCESS);
        } else {
            // Se não tiver chave, impede a porta de abrir e mostra mensagem
            player.displayClientMessage(
                Component.literal("Porta trancada! Você precisa de uma chave."),
                true
            );
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.FAIL);

        }

        // CANCELA o evento para impedir qualquer outra ação (placas, botões, vanilla etc)
        event.setCanceled(true);
        event.setUseBlock(Event.Result.DENY);
        event.setUseItem(Event.Result.DENY);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == ModVillagers.TRADER_LIFE.get()){
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(ModItems.ESSENCE_Of_LIFE.get(), 5),
                new ItemStack(ModItems.PLASTIC_SWORD.get(), 1), 6, 4, 0.05f));
        }
    }
}
