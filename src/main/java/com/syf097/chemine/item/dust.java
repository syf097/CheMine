package com.syf097.chemine.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class dust  extends Item {
 public dust() {
	 super();
	 this.setUnlocalizedName("dust");
	 this.setHasSubtypes(true);
	 this.setCreativeTab(CreativeTabs.MATERIALS);
 }
	public boolean preInit() {
		this.setRegistryName("dust");
		 ForgeRegistries.ITEMS.register(this);
		return true;
	}
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	    {
	        if (this.isInCreativeTab(tab))
	        {
	            for(int i=0;i<Resource.values() .length;i++)
	        	items.add(new ItemStack(this,1,i));
	        }
        }
	  public String getUnlocalizedName(ItemStack stack)
	    {
	        int i = stack.getMetadata();
	        return super.getUnlocalizedName() + "." + Resource.getName(i);
	    }
}
