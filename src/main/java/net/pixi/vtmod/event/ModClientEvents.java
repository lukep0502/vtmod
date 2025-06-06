package net.pixi.vtmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.pixi.vtmod.VtMod;

@Mod.EventBusSubscriber(modid = VtMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    
}