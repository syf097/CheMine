package com.syf097.chemine.proxy;

import com.jcraft.jorbis.Block;
import com.syf097.chemine.loader.BlockLoader;
import com.syf097.chemine.loader.FluidLoader;
import com.syf097.chemine.loader.ItemLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class client extends common {
	  @Override
	    public void preInit(FMLPreInitializationEvent event)
	    {
	        super.preInit(event);
	   	 FluidLoader.registerRenders();
		    BlockLoader.registerModels();
		    ItemLoader.render();
	    }

	    @Override
	    public void init(FMLInitializationEvent event)
	    {
	        super.init(event);
	    }

	    @Override
	    public void postInit(FMLPostInitializationEvent event)
	    {
	        super.postInit(event);
	    }
}
