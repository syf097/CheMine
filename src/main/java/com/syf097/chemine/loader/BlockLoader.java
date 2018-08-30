package com.syf097.chemine.loader;

import com.syf097.chemine.block.BlockMachine;
import com.syf097.chemine.block.BlockOre;
import com.syf097.chemine.block.fluid.BlockFluidCoalGas;

import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BlockLoader {
		public  static  BlockFluidCoalGas blockfluidcoalgas = new BlockFluidCoalGas();
		public  static BlockOre blockore = new BlockOre();
		public  static  BlockMachine blockmachine = new BlockMachine();
		public BlockLoader(FMLPreInitializationEvent event)
	    { 	
	    
	 	blockmachine.preinit();	
		 blockore.preInit(); 
	    blockfluidcoalgas.preinti();
	    }
		public static void registerModels() {
			blockore.registerModels();
		}
}
