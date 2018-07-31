package com.syf097.chemine.loader;

import com.syf097.chemine.block.BlockMachine;
import com.syf097.chemine.block.BlockOre;
import com.syf097.chemine.block.fluid.BlockFluidCoalGas;

import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BlockLoader {
		public  static  BlockFluidCoalGas blockfluidcoalgas = new BlockFluidCoalGas();
	
		public BlockLoader(FMLPreInitializationEvent event)
	    { 	
	    BlockOre blockore = new BlockOre();
		BlockMachine blockmachine = new BlockMachine();
	 	blockmachine.preinit();	
		 blockore.preInit(); 
	    blockore.registerModels();
	    blockfluidcoalgas.preinti();
	    }
}
