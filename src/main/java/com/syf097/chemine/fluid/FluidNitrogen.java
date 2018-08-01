package com.syf097.chemine.fluid;

import com.syf097.chemine.chemine;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidNitrogen extends Fluid{
	    public static final ResourceLocation still = new ResourceLocation(chemine.MODID + ":" + "fluid/nitrogen_still");
	    public static final ResourceLocation flowing = new ResourceLocation(chemine.MODID + ":" + "fluid/nitrogen_flow");
	public FluidNitrogen() {

		super("nitrogen", still, flowing);
		   this.setDensity(800);
	        this.setViscosity(1200);
	        this.setLuminosity(0);
	        this.setTemperature(300);
	        this.setGaseous(true);
	}

}
