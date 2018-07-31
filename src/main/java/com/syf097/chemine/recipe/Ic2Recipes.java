package com.syf097.chemine.recipe;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

public class Ic2Recipes   {
	
	public static void Init() {
		IRecipeInput input = Recipes.inputFactory.forStack( IC2Items.getItem("dust", "coal"));
	Recipes.cannerEnrich.addRecipe(FluidRegistry.getFluidStack("water",1000), input,FluidRegistry.getFluidStack("coalgas",1000));
	}



}
