package com.syf097.chemine.recipe;

import com.syf097.chemine.loader.BlockLoader;
import com.syf097.chemine.loader.ItemLoader;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FurnaceRecipe {
public static void Init() {
	GameRegistry.addSmelting(new ItemStack(ItemLoader.dust,1,4), new ItemStack(ItemLoader.dust,1,2), 0.5F);
	GameRegistry.addSmelting(new ItemStack(ItemLoader.dust,1,3), new ItemStack(Items.IRON_INGOT,1), 0.5F);
	GameRegistry.addSmelting(new ItemStack(ItemLoader.dust,1,2), new ItemStack(Items.IRON_NUGGET,3), 0.5F);
}
}
