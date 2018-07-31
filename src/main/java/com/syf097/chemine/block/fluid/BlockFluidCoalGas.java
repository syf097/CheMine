package com.syf097.chemine.block.fluid;

import com.syf097.chemine.loader.FluidLoader;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockFluidCoalGas extends BlockFluidClassic{

	public BlockFluidCoalGas() {
		 super(FluidLoader.fluidCoalGas, Material.WATER);
	        this.setUnlocalizedName("fluidCoalGas");
	        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

public boolean preinti() {
	this.setRegistryName("fluid_coalgas");
	ForgeRegistries.BLOCKS.register(this);
	return true;
}
}
