package com.syf097.chemine.proxy;

import com.syf097.chemine.loader.BlockLoader;
import com.syf097.chemine.loader.WorldGenLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class common {
	public void preInit(FMLPreInitializationEvent event)
    {
		 new BlockLoader(event);
	
    }

    public void init(FMLInitializationEvent event)
    {
	 new WorldGenLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
