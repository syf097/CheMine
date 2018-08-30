package com.syf097.chemine.recipe;

import com.syf097.chemine.loader.BlockLoader;
import com.syf097.chemine.loader.ItemLoader;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;

public class Ic2Recipes   {
	
	public static void Init() {
	//cannerEnrich recipe
	IRecipeInput input = Recipes.inputFactory.forStack( IC2Items.getItem("dust", "coal"));
	Recipes.cannerEnrich.addRecipe(FluidRegistry.getFluidStack("water",1000), input,FluidRegistry.getFluidStack("coalgas",1000));
	
	//macerator recipe
	IRecipeInput pysite = Recipes.inputFactory.forStack(new ItemStack(BlockLoader.blockore,1,0));
	Recipes.macerator.addRecipe(pysite, null, false, new ItemStack(ItemLoader.dust,2,4));
	
	//blastfuenace recipe
	IRecipeInput ferrite = Recipes.inputFactory.forStack(new ItemStack(ItemLoader.dust,1,2));
	IRecipeInput Sponge = Recipes.inputFactory.forStack(new ItemStack(ItemLoader.dust,1,3));
	NBTTagCompound metaferrite = new NBTTagCompound();
	NBTTagCompound metasponge = new NBTTagCompound();
	  metaferrite.setInteger("fluid", 1);
	  metaferrite.setInteger("duration", 400);
	  metasponge.setInteger("fluid", 10);
	  metasponge.setInteger("duration", 100);
    Recipes.blastfurnace.addRecipe(ferrite, metaferrite, false ,new ItemStack(ItemLoader.dust,1,3));
    Recipes.blastfurnace.addRecipe(Sponge, metasponge, false ,new ItemStack(Items.IRON_INGOT));
	
    //orewash recipe
    IRecipeInput pysitewash = Recipes.inputFactory.forStack(new ItemStack(ItemLoader.dust,1,4));
    ItemStack outputpysitewash = IC2Items.getItem("dust", "small_sulfur");
    outputpysitewash.setCount(2);
    NBTTagCompound metapysite = new NBTTagCompound();
    metapysite.setInteger("amount", 1000);
    Recipes.oreWashing.addRecipe(pysitewash, metapysite,false, new ItemStack(ItemLoader.dust,1,0),outputpysitewash,IC2Items.getItem("dust", "stone"));
	}
    

}
