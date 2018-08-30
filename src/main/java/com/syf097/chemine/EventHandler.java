package com.syf097.chemine;

import com.syf097.chemine.item.CrushHummer;
import com.syf097.chemine.loader.ItemLoader;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class EventHandler {
	public EventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	@SubscribeEvent
	 public void onHarvestDrops(HarvestDropsEvent event)
    {
        if (!event.getWorld().isRemote)
        {
          if(event.getHarvester()!=null)
           if(ItemStack.areItemsEqualIgnoreDurability(new ItemStack(ItemLoader.hummer), event.getHarvester().getHeldItemMainhand())) {
        	  ItemStack stack = event.getDrops().get(0);  
        	  if(Recipes.macerator.apply(stack, true) != null) {
        		  RecipeOutput output = Recipes.macerator.getOutputFor(stack, true);
                   ItemStack newStack =   output.items.get(0);
                   newStack .setCount(1);
        		  event.getDrops().set(0, newStack );
        	  }
           
          }
        }
    }

}
