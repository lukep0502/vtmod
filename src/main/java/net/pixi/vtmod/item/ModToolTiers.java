package net.pixi.vtmod.item;

import net.minecraft.world.item.Tier;
//import net.minecraft.world.item.Tiers; vanila tiers
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.pixi.vtmod.util.ModTags;

public class ModToolTiers {
    public static final Tier PLASTIC = new ForgeTier(50, 1, 0f, 20,
            ModTags.Blocks.NEEDS_PLASTIC_TOOL, () -> Ingredient.of(ModItems.PLASTIC.get()),
            ModTags.Blocks.INCORRECT_FOR_PLASTIC_TOOL);
}