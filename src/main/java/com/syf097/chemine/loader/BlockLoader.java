package com.syf097.chemine.loader;

import com.syf097.chemine.block.BlockOre;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BlockLoader {
	  public BlockLoader(FMLPreInitializationEvent event)
	    {
		 BlockOre blockore = new BlockOre();
		 blockore.preInit(); 
	    blockore.registerModels();
	    }
}
