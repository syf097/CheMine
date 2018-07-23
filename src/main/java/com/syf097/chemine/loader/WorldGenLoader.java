package com.syf097.chemine.loader;

import net.minecraftforge.fml.common.eventhandler.Event;

import com.syf097.chemine.worldgen.WorldGenFerrovanadium;
import com.syf097.chemine.worldgen.WorldGenPyrite;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldGenLoader {
 public WorldGenPyrite generaterpyrite = new WorldGenPyrite();
 public WorldGenFerrovanadium generaterferrovanadium = new WorldGenFerrovanadium();
 private BlockPos pos;
	   public WorldGenLoader()
	    {
	        MinecraftForge.ORE_GEN_BUS.register(this);
	    }

	    @SubscribeEvent
	    public void onOreGenGenerateMinable(OreGenEvent.GenerateMinable event)
	    {
	        if (event.getType() == OreGenEvent.GenerateMinable.EventType.IRON)
	        {
	            event.setResult(Event.Result.DENY);
	        }
	    }
	    @SubscribeEvent
	    public void onOreGenPost(OreGenEvent.Post event)
	    {
	    	  if (!event.getPos().equals(this.pos))
	          {
	    		  this.pos = event.getPos();
	    	generaterpyrite.generate(event.getWorld(), event.getRand(), event.getPos());
	    	generaterferrovanadium.generate(event.getWorld(), event.getRand(), event.getPos());
	          }
	    }
}
