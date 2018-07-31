package com.syf097.chemine.loader;

import com.syf097.chemine.recipe.Ic2Recipes;


import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


public class RecipeLoader {
	 public   RecipeLoader(FMLInitializationEvent event)
	    {
	  Ic2Recipes.Init();
	    }
}
