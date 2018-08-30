package com.syf097.chemine.proxy;

import com.syf097.chemine.EventHandler;
import com.syf097.chemine.loader.BlockLoader;
import com.syf097.chemine.loader.FluidLoader;
import com.syf097.chemine.loader.ItemLoader;
import com.syf097.chemine.loader.RecipeLoader;
import com.syf097.chemine.loader.TileLoader;
import com.syf097.chemine.loader.WorldGenLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class common {
	public void preInit(FMLPreInitializationEvent event)
    {
		new FluidLoader(event); 
		new BlockLoader(event);
		 new TileLoader(event);
		 new ItemLoader(event);
	
    }

    public void init(FMLInitializationEvent event)
    {
	 new WorldGenLoader();
	 new RecipeLoader(event);
	 new EventHandler();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
