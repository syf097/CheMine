package com.syf097.chemine;

import org.apache.logging.log4j.Logger;

import com.syf097.chemine.proxy.*;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
@Mod(modid =chemine.MODID, name = chemine.NAME, version =chemine.VERSION, acceptedMinecraftVersions = "1.12")
public class chemine {
		 public static final String MODID = "chemine";
	    public static final String NAME = "CheMine";
	    public static final String VERSION = "1.0.0";
	    private Logger logger;
	    @SidedProxy(clientSide = "com.syf097.chemine.proxy.client", 
	            serverSide = "com.syf097.chemine.proxy.common")
	    public static common proxy;
	    @Instance(chemine.MODID)
	    public static chemine instance;

	    @EventHandler
	    public void preInit(FMLPreInitializationEvent event)
	    {
	    	 logger = event.getModLog();
	    	proxy.preInit(event);
	    }

	    @EventHandler
	    public void init(FMLInitializationEvent event)
	    {
	    	 proxy.init(event);
	    }

	    @EventHandler
	    public void postInit(FMLPostInitializationEvent event)
	    {
	    	 proxy.postInit(event);
	    }
	    public Logger getLogger()
	    {
	        return logger;
	    }
	}
