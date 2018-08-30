package com.syf097.chemine.tile;

import javax.annotation.Nullable;

import com.syf097.chemine.loader.ItemLoader;
import com.syf097.chemine.recipe.SeparatorRecipe;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileLeacher extends TileEntity   {
	protected FluidTank input = new FluidTank(10000);
	 protected FluidTank output = new FluidTank(10000);

	 private static final int[] SLOTS = new int[] {0};
	 private int processmax = 2000;
	 protected int process = 0;

	 
	
	public boolean isItemValidForSlot(int index, ItemStack stack) {
	if (index==0&&stack.isItemEqualIgnoreDurability(new ItemStack(ItemLoader.dust))) {
		return true;
	}else {
		return false;
	}
		
	}

	public String getName() {

		return  "container.leacher";
	}

	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		 return this.isItemValidForSlot(index, itemStackIn);
	}



	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return false;
	}

	 // capability system
     @Override
	    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	    {
	        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)||CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.equals(capability))
	        {
	            return true;
	        } 
	        return super.hasCapability(capability, facing);
	    }
     @SuppressWarnings("unchecked")
     protected ItemStackHandler handler = new ItemStackHandler();
     @Override
	    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	    {
	        if (CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.equals(capability))
	        {
	        	
	        	return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(new IFluidHandler() {

					@Override
					public IFluidTankProperties[] getTankProperties() {

						FluidTankInfo inputInfo = input.getInfo();
						FluidTankInfo outputInfo = output.getInfo();					
						return new IFluidTankProperties[] { new FluidTankProperties(inputInfo.fluid, inputInfo.capacity, true, false), new FluidTankProperties(outputInfo.fluid, outputInfo.capacity, false, true) };
					}

					@Override
					public int fill(FluidStack resource, boolean doFill) {

						if (facing != EnumFacing.DOWN && facing != EnumFacing.UP ) {
							if (!SeparatorRecipe.isValid(resource)) {
								return 0;
							}
							return input.fill(resource, doFill);
						}
						return 0;
					}

					@Nullable
					@Override
					public FluidStack drain(FluidStack resource, boolean doDrain) {

						if (facing == EnumFacing.UP||facing ==  EnumFacing.DOWN) {
							FluidStack ret = output.drain(resource, doDrain);
							return ret;
						
						}
						return null;
					}

					@Nullable
					@Override
					public FluidStack drain(int maxDrain, boolean doDrain) {


						if (facing == EnumFacing.UP||facing ==  EnumFacing.DOWN) {
							FluidStack ret = output.drain(maxDrain, doDrain);
							return ret;
						}
						
						return null;
					}
				});
	        	
	        } if(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {

	        	 return (T) handler;
	        }
	        
	        return super.getCapability(capability, facing);
	    }



	  
}
