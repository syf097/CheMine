package com.syf097.chemine.recipe;

import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class SeparatorRecipe {
final FluidStack input;
final FluidStack outputup;
final FluidStack outputdown;
public static int num = 0;
public static Map<String, SeparatorRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
private static Set<String> validationFluids = new ObjectOpenHashSet<>();
	public SeparatorRecipe(FluidStack input,FluidStack outputup,FluidStack outputdown) {
		this.input = input;
		this.outputdown = outputdown;
		this.outputup = outputup;
	}
	
	public static void addRecipe(FluidStack input,FluidStack outputup,FluidStack outputdown) {
		SeparatorRecipe newrecipe = new SeparatorRecipe( input, outputup, outputdown);
		recipeMap.put(input.getFluid().getName(), newrecipe);
		validationFluids.add(input.getFluid().getName());
		num++;
	}
	public static boolean isValid(FluidStack fluid) {
		return fluid != null && validationFluids.contains(fluid.getFluid().getName());
		
	}
	
	public FluidStack getInput() {
		return input;
	}
	public FluidStack getOutputup() {
		return outputup;
	}
	public FluidStack getOutputdown() {
		return outputdown;
	}
	public static SeparatorRecipe getRecipe(FluidStack input) {
		if(isValid(input)) {
			return recipeMap.get(input.getFluid().getName());	
		}
		return null;
	}
	//initialize
	public static void init(){
		addRecipe(FluidRegistry.getFluidStack("coalgas", 1000),FluidRegistry.getFluidStack("ic2hydrogen", 500),FluidRegistry.getFluidStack("nitrogen", 500));
	}
}

