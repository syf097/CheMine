package com.syf097.chemine.loader;

import com.syf097.chemine.chemine;
import com.syf097.chemine.tile.TileSeparator;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.GameData;

public class TileLoader {
	 public  TileLoader(FMLPreInitializationEvent event)
	    {
		 registerTileEntity(TileSeparator.class, "separator");
	    }

	    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id)
	    {
	    	 GameRegistry.registerTileEntity(tileEntityClass, "chemine"+":"+id);
	    }
}
