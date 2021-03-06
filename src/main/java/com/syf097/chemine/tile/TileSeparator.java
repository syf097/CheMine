package com.syf097.chemine.tile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.syf097.chemine.recipe.SeparatorRecipe;

import ic2.api.tile.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileSeparator extends TileEntity implements  ITickable {
	 private static EnumFacing facing =EnumFacing.EAST;
	protected FluidTank input = new FluidTank(10000);
	 protected FluidTank outputdown = new FluidTank(10000);
	 protected FluidTank outputup = new FluidTank(10000);
	 protected int processrem = 100; 
	   public boolean canProcess()
	     {
		   SeparatorRecipe recipe =SeparatorRecipe.getRecipe(input.getFluid());
		   if (input.getFluid()!=null){
		    	if(input.getFluid().containsFluid(recipe.getInput())) {
		     		if((recipe.getOutputup().isFluidEqual(outputup.getFluid())||outputup.getFluid()==null)&&(recipe.getOutputdown().isFluidEqual(outputdown.getFluid())||outputdown.getFluid()==null)) {
		    		if(10000-outputup.getFluidAmount()>recipe.getOutputup().amount&&10000-outputdown.getFluidAmount()>recipe.getOutputdown().amount) {
		    			return true;
		    		}
		     		}
		    	}
		     }
		   return false;
	     }
	 private void Process() {
		 SeparatorRecipe recipe =SeparatorRecipe.getRecipe(input.getFluid());
		 input.drain(recipe.getInput().amount, true);
		 outputup.fill(recipe.getOutputup(), true);
		 outputdown.fill(recipe.getOutputdown(),true);
	 }
	 public FluidStack getInput() {
		 return input.getFluid();
	 }
	 public void Transoutput() {
		 
	 }
	 public double getProcess() {
		 return processrem;
	 }
	
	 @Override
	    public void update()
	    {
		
	        if (!this.world.isRemote&&this.canProcess())
	        { 
	        	
	        	if (processrem <=0){
	        		 this.Process();
	        		 processrem = 100;
	        	}
	        	else {
	        	processrem--;	
	        	}
	        }
	    }
	 //nbt method
	    @Override
	    public void readFromNBT(NBTTagCompound compound)
	    {
	        super.readFromNBT(compound);
	       input.readFromNBT(compound.getCompoundTag("input"));
	       outputup.readFromNBT(compound.getCompoundTag("putputup"));
	       outputdown.readFromNBT(compound.getCompoundTag("outputdown"));
	        this.processrem = compound.getInteger("processrem");
	    }

	    @Override
	    public  NBTTagCompound writeToNBT(NBTTagCompound compound)
	    {
	        super.writeToNBT(compound);
	        compound.setInteger("processrem", this.processrem);
	        compound.setTag("input", input.writeToNBT(new NBTTagCompound()));
	        compound.setTag("outputuo", outputup.writeToNBT(new NBTTagCompound()));
	        compound.setTag("outputdowwn", outputdown.writeToNBT(new NBTTagCompound()));
	        return compound;
	    }
	   @Override
	    public void onChunkUnload()
	    {
		   markDirty();
	    }

	    // capability system
       @Override
	    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	    {
	        if (CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.equals(capability))
	        {
	            return true;
	        }
	        return super.hasCapability(capability, facing);
	    }
	  @SuppressWarnings("unchecked")
	    @Override
	    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	    {
	        if (CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.equals(capability))
	        {
	        	
	        	return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(new IFluidHandler() {

					@Override
					public IFluidTankProperties[] getTankProperties() {

						FluidTankInfo inputInfo = input.getInfo();
						FluidTankInfo outputupInfo = outputup.getInfo();
						FluidTankInfo outputdownInfo = outputdown.getInfo();
						return new IFluidTankProperties[] { new FluidTankProperties(inputInfo.fluid, inputInfo.capacity, true, false), new FluidTankProperties(outputupInfo.fluid, outputupInfo.capacity, false, true),new FluidTankProperties(outputdownInfo.fluid, outputdownInfo.capacity, false, true) };
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

						if (facing == EnumFacing.UP) {
							FluidStack ret = outputup.drain(resource, doDrain);
							return ret;
						}else if (facing == EnumFacing.DOWN) {
							FluidStack ret = outputdown.drain(resource, doDrain);
							return ret;
						}
						return null;
					}

					@Nullable
					@Override
					public FluidStack drain(int maxDrain, boolean doDrain) {


						if (facing == EnumFacing.UP) {
							FluidStack ret = outputup.drain(maxDrain, doDrain);
							return ret;
						}else if (facing == EnumFacing.DOWN) {
							FluidStack ret = outputdown.drain(maxDrain, doDrain);
							return ret;
						}
						return null;
					}
				});
	        }
	        return super.getCapability(capability, facing);
	    }
	  
	
	    
}
