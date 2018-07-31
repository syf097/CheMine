package com.syf097.chemine.fluid;

import com.syf097.chemine.chemine;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidCoalGas extends Fluid{
	    public static final ResourceLocation still = new ResourceLocation(chemine.MODID + ":" + "fluid/coalgas_still");
	    public static final ResourceLocation flowing = new ResourceLocation(chemine.MODID + ":" + "fluid/coalgas_flow");
	public FluidCoalGas() {

		super("coalgas", still, flowing);
		   this.setDensity(2060);
	        this.setViscosity(750);
	        this.setLuminosity(0);
	        this.setTemperature(300);
	        this.setGaseous(true);
	}

}
